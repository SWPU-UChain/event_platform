package com.dataht.event.controller;

import com.dataht.event.service.EventAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventAnalyseController {

    private EventAnalyseService eventAnalyseService;

    @Autowired
    public EventAnalyseController(EventAnalyseService eventAnalyseService) {
        this.eventAnalyseService = eventAnalyseService;
    }

    @RequestMapping("/tag/{sentence}")
    public String getEventTag(@PathVariable("sentence") String sentence) throws Exception {
        return eventAnalyseService.getEventTag(sentence);
    }

    @RequestMapping("/emotion/{sentence}")
    public String getEventEmotion(@PathVariable("sentence") String sentence) throws Exception {
        return eventAnalyseService.getEventEmotion(sentence);
    }

    @RequestMapping("/abstract/{sentence}")
    public String getEventAbstract(@PathVariable("sentence") String sentence) throws Exception {
        return eventAnalyseService.getEventAbstract(sentence);
    }

    @RequestMapping("/keyword/{sentence}")
    public String getEventKeyword(@PathVariable("sentence") String sentence) throws Exception {
        return eventAnalyseService.getEventKeyword(sentence);
    }
}
