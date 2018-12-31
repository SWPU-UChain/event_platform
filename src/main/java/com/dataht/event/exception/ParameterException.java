package com.dataht.event.exception;

import org.springframework.http.HttpStatus;

public class ParameterException extends BaseException {
    public ParameterException() {
        super("参数不合法", HttpStatus.BAD_REQUEST);
    }
}
