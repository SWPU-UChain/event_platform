package com.dataht.event.controller;

import com.dataht.event.exception.NoCommentException;
import com.dataht.event.model.view.EventComment;
import com.dataht.event.model.view.Message;
import com.dataht.event.service.EventCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("event/{urlMd5}/comment")
public class EventCommentController {

    private EventCommentService eventCommentService;

    @Autowired
    public EventCommentController(EventCommentService eventCommentService) {
        this.eventCommentService = eventCommentService;
    }

    @GetMapping
    public EventComment get(@PathVariable("urlMd5") String urlMd5) {
        return eventCommentService.get(urlMd5);
    }

    @ExceptionHandler(NoCommentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Message handleNotFoundException(NoCommentException exception) {
                return new Message(exception.getMessage());
    }
}
