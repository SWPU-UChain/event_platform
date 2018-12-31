package com.dataht.event.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {

    private HttpStatus status;

    public BaseException(String message, HttpStatus status) {

        super(message);
        this.status = status;
    }

    @Override
    public String toString() {
        return "BaseException{" +
                "message='" + getMessage() + '\'' +
                ", status=" + status +
                '}';
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

}
