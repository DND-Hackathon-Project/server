package com.coderumi.server.controller;

import com.coderumi.server.dto.res.MemberRes;
import com.coderumi.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/members")
@RestController
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public List<Long> getMembers() {
        return memberService.getMembers();
    }

    @GetMapping("/{memberId}")
    public MemberRes getMember(@PathVariable Long memberId) {
        return memberService.getMember(memberId);
    }
}
