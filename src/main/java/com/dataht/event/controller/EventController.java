package com.dataht.event.controller;


import com.dataht.event.exception.NoEventFoundException;
import com.dataht.event.model.jsonb.KeyWords;
import com.dataht.event.model.view.EventDetail;
import com.dataht.event.model.view.Message;
import com.dataht.event.model.view.PageEvent;
import com.dataht.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/event/{standard}/{category}/{page}")
    public Page<PageEvent> getEventByPage(@PathVariable String standard,
                                          @PathVariable String category,
                                          @PathVariable int page) {
        return eventService.getEvents(standard, category, page);
    }

    @GetMapping("/event/{urlMd5}")
    public EventDetail getEventById(@PathVariable("urlMd5") String urlMd5) {
        return eventService.getEventDetail(urlMd5);
    }

    @GetMapping("/event/{urlMd5}/keywords")
    public List<KeyWords> getKeywords(@PathVariable("urlMd5") String urlMd5) {
        return eventService.getKeywords(urlMd5);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Message handleNumberFormatException(NumberFormatException e) {
        return new Message(e.getMessage());
    }

    @ExceptionHandler(NoEventFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Message handleNotFoundException(NoEventFoundException exception) {
        return new Message(exception.getMessage());
    }


}
