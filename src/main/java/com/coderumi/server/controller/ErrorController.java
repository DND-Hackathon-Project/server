package com.coderumi.server.controller;

import com.coderumi.server.common.apipayload.ErrorStatus;
import com.coderumi.server.common.exception.GeneralException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public class ErrorController {

    @GetMapping("/general-exception")
    public String throwGeneralException() {
        throw new GeneralException(ErrorStatus._BAD_REQUEST);
    }

    @PostMapping("/method-argument-not-valid-exception")
    public String throwMethodArgumentNotValidException(@Valid @RequestBody TestDTO testDTO) {
        return "ok";
    }

    @GetMapping("/constraint-violation-exception/{id}")
    public String throwConstraintViolationException(@PathVariable @Min(1) Long id) {
        return "ok";
    }

    @Data
    public static class TestDTO {
        @NotBlank(message = "이름은 필수입니다.")
        private String name;

        @Email(message = "이메일 형식이 올바르지 않습니다.")
        private String email;

        @Size(min = 6, message = "비밀번호는 최소 6자 이상이어야 합니다.")
        private String password;
    }
}
