package com.dataht.event.service.impl;

import com.dataht.event.config.CountProperties;
import com.dataht.event.exception.NoEventFoundException;
import com.dataht.event.model.jsonb.RelativeEvent;
import com.dataht.event.model.presistence.Event;
import com.dataht.event.model.view.EventDetail;
import com.dataht.event.repository.EventRepository;
import com.dataht.event.service.EventService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class EventServiceImplTestForGetEventDetail {

    @MockBean
    private EventRepository eventRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private CountProperties countProperties;

    @Test
    public void should_get_event_success_when_event_exist() throws Exception {
        Event event = new Event();
        String title = "title";
        event.setTitle(title);
        String urlMd5 = "urlMd5";
        when(eventRepository.findByUrlMd5(urlMd5)).thenReturn(event);
        EventDetail eventDetail = eventService.getEventDetail(urlMd5);
        assertThat(eventDetail.getTitle(), is(title));
    }

    @Test
    public void should_sort_relative_events_by_relevance_when_relative_events_not_null() throws Exception {
        Integer[] values = {43, 95, 23, 79};
        List<RelativeEvent> relativeEvents = Stream
                .of(values)
                .map(value -> {
                    RelativeEvent relativeEvent = new RelativeEvent();
                    relativeEvent.setValue(value);
                    return relativeEvent;
                })
                .collect(toList());
        Event event = new Event();
        event.setRelative(relativeEvents);
        String urlMd5 = "urlMd5";
        when(eventRepository.findByUrlMd5(urlMd5)).thenReturn(event);
        EventDetail eventDetail = eventService.getEventDetail(urlMd5);
        List<RelativeEvent> expect = Stream
                .of(values)
                .sorted(Comparator.reverseOrder())
                .map(relevance -> {
                    RelativeEvent relativeEvent = new RelativeEvent();
                    relativeEvent.setValue(relevance);
                    return relativeEvent;
                })
                .collect(toList());
        assertThat(eventDetail.getRelative(), is(expect));
    }

    @Test(expected = NoEventFoundException.class)
    public void should_throw_NoEventFoundException_when_event_not_exist() throws Exception {
        String urlMd5 = "urlMd5";
        when(eventRepository.findByUrlMd5(urlMd5)).thenReturn(null);
        eventService.getEventDetail(urlMd5);
    }
}