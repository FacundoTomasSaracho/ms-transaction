package com.facundosaracho.mstransactions.presentation.exception;

import com.facundosaracho.mstransactions.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.facundosaracho.mstransactions.presentation.exception.ErrorCodes.GENERIC_ERROR;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleException(Exception exception) {
        log.error("Exception: ", exception);
        return new ResponseEntity<>(
                new ErrorDto(GENERIC_ERROR.getCode(), GENERIC_ERROR.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorDto> handleException(BusinessException businessException) {
        return new ResponseEntity<>(new ErrorDto(businessException.getCode(), businessException.getMessage()), HttpStatus.NOT_FOUND);
    }
}


