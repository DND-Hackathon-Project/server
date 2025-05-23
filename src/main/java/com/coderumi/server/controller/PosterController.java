package com.coderumi.server.controller;

import com.coderumi.server.dto.PosterDto;
import com.coderumi.server.dto.res.HottestPosterRes;
import com.coderumi.server.service.PosterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PosterController {
    private final PosterService posterService;

    @PostMapping("/festivals/{festivalId}/posts")
    public void uploadFile(@PathVariable Long festivalId,
                           @RequestParam MultipartFile file,
                           @RequestParam Long memberId) throws IOException {
        posterService.uploadFile(festivalId, memberId, file);
    }

    @GetMapping("/festivals/{festivalId}/posters")
    public List<PosterDto> getPosters(@PathVariable(name = "festivalId") Long id) {
        return posterService.getPosters(id);
    }

    @GetMapping("/posters")
    public List<PosterDto> searchPosters(@RequestParam(name = "region", required = false) String region,
                                         @RequestParam(name = "isSelected", required = false) boolean isSelected) {
        return posterService.searchPosters(region, isSelected);
    }

    @GetMapping("/posters/hot")
    public HottestPosterRes getHotPosters(@RequestParam(required = false) String region) {
        return posterService.getHotPosters(region);
    }
}
