package com.facundosaracho.mstransactions.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class RestException extends RuntimeException {

    private final Integer code;
    private final String message;
    private final HttpStatus httpStatus;

    RestException(ErrorCode errorCode, HttpStatus httpStatus) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.httpStatus = httpStatus;
    }
}
