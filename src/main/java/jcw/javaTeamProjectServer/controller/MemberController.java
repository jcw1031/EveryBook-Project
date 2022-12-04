package jcw.javaTeamProjectServer.controller;

import jcw.javaTeamProjectServer.dto.PointDto;
import jcw.javaTeamProjectServer.entity.Member;
import jcw.javaTeamProjectServer.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원가입
     */
    @PostMapping("/signup")
    public void signUp(@RequestBody final Member member) {
        memberService.join(member);
    }

    /**
     * 로그인
     */
    @GetMapping("/login/{id}")
    public Member login(@PathVariable("id") final String id, @RequestParam("password") final String password) {
        Optional<Member> member = memberService.findByMemberId(id);
        if (member.isPresent()) {
            if (member.get().getMemberPassword().equals(password)) {
                log.info("login success!");
                return member.get();
            } else {
                log.info("wrong password!");
                return null;
            }
        } else {
            log.info("wrong id!");
            return null;
        }
    }

    /**
     * 회원 리스트
     */
    @GetMapping("/list")
    public List<Member> memberList() {
        return memberService.memberList();
    }

    @GetMapping("/{id}")
    public Member findMember(@PathVariable("id") Long memberKey) {
        Optional<Member> optionalMember = memberService.findById(memberKey);
        if (optionalMember.isPresent()) {
            return optionalMember.get();
        } else {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }
    }
}