package com.coderumi.server.common.apipayload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import java.util.Locale;

@AllArgsConstructor
public enum ErrorStatus implements ResponseStatus {

    // common
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "common.bad-request"),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "common.unauthorized"),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "common.forbidden"),
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "common.internal-server-error"),

    // member
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4000", "member.not-found"),

    // festival
    FESTIVAL_NOT_FOUND(HttpStatus.NOT_FOUND, "FESTIVAL4040", "festival.not-found"),;

    private final HttpStatus httpStatus;
    @Getter
    private final String code;
    private final String messageKey;

    @Override
    public ErrorResponseDTO getCustomResponseDTO(MessageSource messageSource) {
        return new ErrorResponseDTO(httpStatus, code, messageSource.getMessage(messageKey, null, Locale.KOREA));
    }
}
