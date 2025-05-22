package com.coderumi.server.common.apipayload;

import org.springframework.context.MessageSource;

public interface ResponseStatus {
    ErrorResponseDTO getCustomResponseDTO(MessageSource messageSource);
}
