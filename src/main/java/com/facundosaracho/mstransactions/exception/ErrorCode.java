package com.facundosaracho.mstransactions.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    NO_COMPANIES_WERE_FOUND(5000, "No companies were found.");

    private final Integer code;
    private final String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
