package com.dataht.event.controller;

import com.dataht.event.exception.NotFoundException;
import com.dataht.event.model.view.Message;
import com.dataht.event.service.HotWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("word/hot")
public class HotWordController {

    private HotWordService hotWordService;

    @Autowired
    public HotWordController(HotWordService hotWordService) {
        this.hotWordService = hotWordService;
    }

    @GetMapping
    public List<String> getNewest() {
        return hotWordService.getNewest();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Message handleNotFoundException(NotFoundException e) {
        return new Message(e.getMessage());
    }
}
