package com.coderumi.server.controller;

import com.coderumi.server.service.FestivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coderumi.server.dto.FestivalDto;
import com.coderumi.server.service.FestivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("festivals")
public class FestivalController {

    private final FestivalService festivalService;

    @GetMapping("/init")
    public void getData() {
        festivalService.init();
    }

//    @GetMapping
//    public FestivalDto getFestival(@PathVariable(name = "festivalId") Long id) {
//        return festivalService.getFestival(id);
//    }


//    @GetMapping
//    public FestivalDto getSelectedFestival() {
//        return festivalService.getFestival(id);
//    }
}
