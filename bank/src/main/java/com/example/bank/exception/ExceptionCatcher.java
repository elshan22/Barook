package com.example.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionCatcher {

    @ExceptionHandler(WalletNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleWalletNotFound(WalletNotFoundException e) {
        return new ResponseEntity<>(new ExceptionResponse(e.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WalletAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleWalletAlreadyExists(WalletNotFoundException e) {
        return new ResponseEntity<>(new ExceptionResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ExceptionResponse> handleInsufficientBalance(InsufficientBalanceException e) {
        return new ResponseEntity<>(new ExceptionResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }
}
