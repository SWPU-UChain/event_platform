package com.dataht.event.exception;

import org.springframework.http.HttpStatus;

public class NoCommentException extends BaseException {
    public NoCommentException() {
        super("暂无评论", HttpStatus.NOT_FOUND);
    }
}
