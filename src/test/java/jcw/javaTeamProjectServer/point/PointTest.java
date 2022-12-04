package jcw.javaTeamProjectServer.point;

import jcw.javaTeamProjectServer.entity.Member;
import jcw.javaTeamProjectServer.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PointTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    public void testPoint() throws Exception {
        //given
        Optional<Member> optionalMember = memberRepository.findById(1L);
        Member member = optionalMember.get();
        member.updatePoint(member.getMemberPoint() + 100000);
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Assertions.assertThat(member.getMemberKey()).isEqualTo(savedMember.getMemberKey());
        Assertions.assertThat(member.getMemberName()).isEqualTo(savedMember.getMemberName());

        System.out.println(savedMember.getMemberPoint());
    }
}
