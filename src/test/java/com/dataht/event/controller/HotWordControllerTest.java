package com.dataht.event.controller;

import com.dataht.event.exception.NotFoundException;
import com.dataht.event.model.view.Message;
import com.dataht.event.service.HotWordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("dev")
public class HotWordControllerTest {

    @MockBean
    private HotWordService hotWordService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void should_response_200_when_get_newest_hot_words_success() throws Exception {
        when(hotWordService.getNewest()).thenReturn(Collections.emptyList());
        ResponseEntity<List> entity = restTemplate.getForEntity("/word/hot", List.class);
        assertThat(entity.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void should_response_404_when_not_any_hot_words_founds() throws Exception {
        when(hotWordService.getNewest()).thenThrow(new NotFoundException(""));
        ResponseEntity<Message> entity = restTemplate.getForEntity("/word/hot", Message.class);
        assertThat(entity.getStatusCode(), is(HttpStatus.NOT_FOUND));
    }
}