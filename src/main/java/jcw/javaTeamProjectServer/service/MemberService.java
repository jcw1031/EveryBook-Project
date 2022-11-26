package jcw.javaTeamProjectServer.service;

import jcw.javaTeamProjectServer.entity.Member;
import jcw.javaTeamProjectServer.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(Member member) {
        Member joinMember = validateDuplicatedUser(member);
        return memberRepository.save(joinMember);
    }

    @Transactional
    Member validateDuplicatedUser(Member member) {
        log.info("member in validate = {}", member);
        Optional<Member> optionalUser = memberRepository.findByMemberId(member.getMemberId());
        if (optionalUser.isPresent()) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        } else {
            return new Member(0L, member.getMemberId(), member.getMemberPassword(), member.getMemberName(), member.getMemberPhone(), member.getMemberAge());
        }
    }

    public List<Member> memberList() {
        return memberRepository.findAll();
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    public Optional<Member> findByMemberId(String loginId) {
        return memberRepository.findByMemberId(loginId);
    }
}
