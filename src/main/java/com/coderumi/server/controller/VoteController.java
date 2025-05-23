package com.coderumi.server.controller;

import com.coderumi.server.service.VoteService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class VoteController {
    private final VoteService voteService;

    @Operation(summary = "투표하기")
    @PostMapping("/posters/{posterId}/votes")
    public void vote(@PathVariable Long posterId, @RequestParam Long memberId) {
        voteService.vote(posterId, memberId);
    }
}
