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
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/member/signup")
    public void signUp(@RequestBody Member member) {
        log.info("member = {}", member);
        String check = member.getMemberId();
        Optional<Member> find = memberService.findByMemberId(member.getMemberId());
        if (find.isPresent()) {
            System.out.println("이미 존재하는 아이디 입니다.");
        } else {
            memberService.join(member);
            System.out.println("가입 완료!");
        }
    }

    @GetMapping("/member/search/all")
    public List<Member> memberList() {
        return memberService.findAll();
    }
}