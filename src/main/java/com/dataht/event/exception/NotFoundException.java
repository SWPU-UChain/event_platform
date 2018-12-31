package com.dataht.event.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {
    private NotFoundException(String message, HttpStatus status) {
        super(message, status);
    }
    public NotFoundException(String message) {
        this(message, HttpStatus.NOT_FOUND);
    }
}
