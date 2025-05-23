package com.coderumi.server.controller;

import com.coderumi.server.service.FestivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coderumi.server.dto.FestivalDto;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("festivals")
public class FestivalController {

    private final FestivalService festivalService;

    @GetMapping("/init")
    public void getData() {
        festivalService.init();
    }

    @GetMapping("/{festivalId}")
    public FestivalDto getFestival(@PathVariable(name = "festivalId") Long id) {
        return festivalService.getFestival(id);
    }
}
