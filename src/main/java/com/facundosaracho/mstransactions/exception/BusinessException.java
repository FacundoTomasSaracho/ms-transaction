package com.facundosaracho.mstransactions.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RestException{

    public BusinessException(ErrorCode errorCode, HttpStatus httpStatus) {
        super(errorCode, httpStatus);
    }
}
