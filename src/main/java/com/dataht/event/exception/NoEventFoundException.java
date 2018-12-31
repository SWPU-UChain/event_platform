package com.dataht.event.exception;

import org.springframework.http.HttpStatus;

public class NoEventFoundException extends BaseException {
    public NoEventFoundException() {
        super("暂无资源", HttpStatus.NOT_FOUND);
    }
}
