package com.dataht.event.service.impl;

import com.dataht.event.exception.NoEventFoundException;
import com.dataht.event.model.jsonb.KeyWords;
import com.dataht.event.model.presistence.Event;
import com.dataht.event.repository.EventRepository;
import com.dataht.event.service.EventService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class EventServiceImplTestForGetKeywords {

    @Autowired
    private EventService eventService;

    @MockBean
    private EventRepository eventRepository;
    @Test
    public void should_return_keyword_list_when_get_success() throws Exception {
        String urlMd5 = "urlMd5";
        Event event = mock(Event.class);
        List<KeyWords> keywords = Collections.emptyList();
        given(event.getKeywords()).willReturn(keywords);
        given(eventRepository.findByUrlMd5(urlMd5)).willReturn(event);
        List<KeyWords> actual = eventService.getKeywords(urlMd5);
        assertThat(actual, is(keywords));
    }

    @Test(expected = NoEventFoundException.class)
    public void should_throw_NoEventFoundException_when_event_not_exist() throws Exception {
        String urlMd5 = "urlMd5";
        given(eventRepository.findByUrlMd5(urlMd5)).willReturn(null);
        eventService.getKeywords(urlMd5);
    }
}