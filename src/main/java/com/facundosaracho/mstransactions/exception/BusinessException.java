package com.facundosaracho.mstransactions.exception;

public class BusinessException extends RestException{

    public BusinessException(ErrorCode errorCode) {
        super(errorCode);
    }
}
