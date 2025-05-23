package com.coderumi.server.controller;

import com.coderumi.server.service.FestivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/festivals")
@RequiredArgsConstructor
@RestController
public class FestivalController {

    private final FestivalService festivalService;

    @GetMapping("/init")
    public void getData() {
        festivalService.init();
    }
}
