package com.coderumi.server.controller;

import com.coderumi.server.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping("/festivals/{festivalId}/posts")
    public void uploadFile(@PathVariable Long festivalId,
                           @RequestParam MultipartFile file,
                           @RequestParam Long memberId) throws IOException {
        postService.uploadFile(festivalId, memberId, file);
    }
}
