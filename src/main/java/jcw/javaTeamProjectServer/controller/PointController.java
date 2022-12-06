package jcw.javaTeamProjectServer.controller;

import jcw.javaTeamProjectServer.dto.PointDTO;
import jcw.javaTeamProjectServer.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/point")
@RequiredArgsConstructor
public class PointController {

    private final MemberService memberService;

    @PutMapping("/add")
    public void addPoint(@RequestBody PointDTO pointDto) {
        memberService.updatePoint(pointDto);
    }

    @PutMapping("/use")
    public void usePoint(@RequestBody PointDTO pointDto) {
        pointDto.reducePoint();
        memberService.updatePoint(pointDto);
    }
}
