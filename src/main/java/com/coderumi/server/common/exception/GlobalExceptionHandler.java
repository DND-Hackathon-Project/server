package com.coderumi.server.common.exception;

import com.coderumi.server.common.apipayload.CustomResponse;
import com.coderumi.server.common.apipayload.ErrorResponseDTO;
import com.coderumi.server.common.apipayload.ErrorStatus;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.*;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<CustomResponse> handleGeneralException(GeneralException e) {
        e.printStackTrace();

        ErrorResponseDTO error = e.getErrorResponse(messageSource);
        CustomResponse customResponse = CustomResponse.onFailure(error.getCode(), error.getMessage());

        return ResponseEntity
                .status(error.getHttpStatus())
                .body(customResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        e.printStackTrace();

        ObjectError first = e.getBindingResult().getAllErrors().stream().findFirst().get();
        String errorMessage = first.getDefaultMessage();

        CustomResponse customResponse = CustomResponse.onFailure(ErrorStatus._BAD_REQUEST.name(), errorMessage);

        return ResponseEntity
                .status(e.getStatusCode())
                .body(customResponse);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<CustomResponse> handleConstraintViolationException(ConstraintViolationException e) {
        e.printStackTrace();

        String errorMessage = e.getConstraintViolations().stream()
                .map(constraintViolation -> constraintViolation.getMessage())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("ConstraintViolationException 추출 도중 에러 발생"));

        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        CustomResponse customResponse = CustomResponse.onFailure(httpStatus.name(), errorMessage);

        return ResponseEntity
                .status(httpStatus)
                .body(customResponse);
    }
}
