package com.facundosaracho.mstransactions.exception;

import lombok.Getter;

@Getter
public class RestException extends RuntimeException {

    private Integer code;
    private String message;

    public RestException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}
