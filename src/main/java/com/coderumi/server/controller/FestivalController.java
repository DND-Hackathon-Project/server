package com.coderumi.server.controller;

import com.coderumi.server.service.FestivalService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "축제 더미 데이터 저장")
    @GetMapping("/init")
    public void getData() {
        festivalService.init();
    }

    @Operation(summary = "특정 축제 상세 정보 조회")
    @GetMapping("/{festivalId}")
    public FestivalDto getFestival(@PathVariable(name = "festivalId") Long id) {
        return festivalService.getFestival(id);
    }
}
