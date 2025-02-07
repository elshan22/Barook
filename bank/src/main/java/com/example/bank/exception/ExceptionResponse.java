package com.example.bank.exception;

import lombok.Getter;

@Getter
public class ExceptionResponse {

    private final String message;
    private final Integer status;

    public ExceptionResponse(String message, Integer status) {
        this.message = message;
        this.status = status;
    }
}
