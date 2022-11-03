package jcw.javaTeamProjectServer.controller;

import jcw.javaTeamProjectServer.entity.Member;
import jcw.javaTeamProjectServer.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user")
public class MemberController {

    @Autowired
    MemberService memberService;

    /**
     * 회원가입
     */
    @PostMapping("/signup")
    public void signUp(@RequestBody Member member) {
        log.info("member = {}", member);
        String check = member.getMemberId();
        Optional<Member> find = memberService.findByMemberId(check);
        if (find.isPresent()) {
            log.info("이미 존재하는 아이디입니다.");
        } else {
            memberService.join(member);
            log.info("가입 완료!");
        }
    }

    /**
     * 로그인
     */
    @GetMapping("/{id}")
    public Member login(@PathVariable("id") String id, @RequestParam("password") String password) {
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
    @GetMapping("/search/all")
    public List<Member> memberList() {
        return memberService.memberList();
    }
}