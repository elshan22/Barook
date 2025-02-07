package com.example.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionCatcher {

    @ExceptionHandler(WalletNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleWalletNotFoundException(WalletNotFoundException e) {
        return new ResponseEntity<>(new ExceptionResponse(e.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }
}
