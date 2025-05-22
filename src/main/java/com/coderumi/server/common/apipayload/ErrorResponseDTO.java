package com.coderumi.server.common.apipayload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@Getter
public class ErrorResponseDTO {
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
