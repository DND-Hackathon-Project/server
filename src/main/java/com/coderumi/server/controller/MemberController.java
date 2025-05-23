package com.coderumi.server.controller;

import com.coderumi.server.dto.res.MemberRes;
import com.coderumi.server.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "유저 ID 리스트 조회")
    @GetMapping
    public List<Long> getMembers() {
        return memberService.getMembers();
    }

    @Operation(summary = "유저 닉네임 조회")
    @GetMapping("/{memberId}")
    public MemberRes getMember(@PathVariable Long memberId) {
        return memberService.getMember(memberId);
    }
}
