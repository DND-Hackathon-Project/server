package com.coderumi.server.controller;

import com.coderumi.server.dto.PosterDto;
import com.coderumi.server.dto.res.HottestPosterRes;
import com.coderumi.server.service.PosterService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PosterController {
    private final PosterService posterService;

    @Operation(summary = "축제에 대한 포스터 업로드")
    @PostMapping("/festivals/{festivalId}/posts")
    public void uploadFile(@PathVariable Long festivalId,
                           @RequestParam MultipartFile file,
                           @RequestParam Long memberId) throws IOException {
        posterService.uploadFile(festivalId, memberId, file);
    }

    @Operation(summary = "특정 축제의 포스터들 조회")
    @GetMapping("/festivals/{festivalId}/posters")
    public List<PosterDto> getPosters(@PathVariable(name = "festivalId") Long id) {
        return posterService.getPosters(id);
    }

    @Operation(summary = "축제 조회")
    @GetMapping("/posters")
    public List<PosterDto> searchPosters(@RequestParam(name = "region", required = false) String region,
                                         @RequestParam(name = "isSelected", required = false) boolean isSelected) {
        return posterService.searchPosters(region, isSelected);
    }

    @Operation(summary = "가장 인기 있는 포스터 조회")
    @GetMapping("/posters/hot")
    public HottestPosterRes getHotPosters(@RequestParam(required = false) String region) {
        return posterService.getHotPosters(region);
    }
}
