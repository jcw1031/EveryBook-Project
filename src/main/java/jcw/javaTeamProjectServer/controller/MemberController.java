package jcw.javaTeamProjectServer.controller;

import jcw.javaTeamProjectServer.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;
    

}
