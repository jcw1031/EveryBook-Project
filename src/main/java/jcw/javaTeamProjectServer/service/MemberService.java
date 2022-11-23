package jcw.javaTeamProjectServer.service;

import jcw.javaTeamProjectServer.entity.Member;
import jcw.javaTeamProjectServer.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public Member join(Member member) {
        return memberRepository.save(member);
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
