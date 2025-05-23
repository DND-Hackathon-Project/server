package com.coderumi.server.controller;

import com.coderumi.server.service.PosterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
}
