package com.dataht.event.controller;

import com.dataht.event.exception.NoCommentException;
import com.dataht.event.model.view.EventComment;
import com.dataht.event.model.view.Message;
import com.dataht.event.service.EventCommentService;
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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("dev")
public class EventCommentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private EventCommentService eventCommentService;

    @Test
    public void should_response_200_when_comment_exist() throws Exception {
        String urlMd5 = "urlMd5";
        String path = String.format("/event/%s/comment", urlMd5);
        EventComment eventComment = new EventComment();
        given(eventCommentService.get(eq(urlMd5))).willReturn(eventComment);
        ResponseEntity<EventComment> entity =
                restTemplate.getForEntity(path, EventComment.class);
        assertThat(entity.getStatusCode(), is(HttpStatus.OK));
        assertThat(entity.getBody(), is(eventComment));
    }

    @Test
    public void should_response_404_when_comment_not_exist() throws Exception {
        String urlMd5 = "urlMd5";
        String path = String.format("/event/%s/comment", urlMd5);
        given(eventCommentService.get(urlMd5)).willThrow(new NoCommentException());
        ResponseEntity<Message> entity =
                restTemplate.getForEntity(path, Message.class);
        assertThat(entity.getStatusCode(), is(HttpStatus.NOT_FOUND));
    }
}