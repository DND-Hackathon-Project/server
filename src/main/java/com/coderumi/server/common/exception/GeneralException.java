package com.coderumi.server.common.exception;

import com.coderumi.server.common.apipayload.ErrorResponseDTO;
import com.coderumi.server.common.apipayload.ErrorStatus;
import lombok.Getter;
import org.springframework.context.MessageSource;

@Getter
public class GeneralException extends RuntimeException {
    private final ErrorStatus errorStatus;

    public GeneralException(ErrorStatus errorStatus) {
        super(errorStatus.getCode());
        this.errorStatus = errorStatus;
    }

    public ErrorResponseDTO getErrorResponse(MessageSource messageSource) {
        return this.errorStatus.getCustomResponseDTO(messageSource);
    }
}
