package com.dataht.event.service.impl;

import com.dataht.event.config.CountProperties;
import com.dataht.event.exception.NoCommentException;
import com.dataht.event.model.presistence.Comment;
import com.dataht.event.model.view.EventComment;
import com.dataht.event.repository.CommentRepository;
import com.dataht.event.service.EventCommentService;
import com.dataht.event.service.inner.CommentCountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class EventCommentServiceImplTestFotGet {

    @MockBean
    private CommentRepository commentRepository;

    @MockBean
    private CommentCountService commentCountService;

    @Autowired
    private EventCommentService eventCommentService;

    @Autowired
    private CountProperties countProperties;

    @Test(expected = NoCommentException.class)
    public void should_throw_NoCommentException_when_comment_not_found() throws Exception {
        String urlMd5 = "urlMd5";
        when(commentRepository.findAllByUrlMd5(urlMd5))
                .thenAnswer(invocation ->
                        new Random().nextInt() % 2 == 1 ?
                                null : Collections.emptyList());
        eventCommentService.get(urlMd5);
    }

    @Test
    public void should_count_all_message_when_get_comment_success() throws Exception {
        List<Comment> comments = singletonList(new Comment());
        String urlMd5 = "urlMd5";
        int top = countProperties.getCommentCount();
        when(commentRepository.findAllByUrlMd5(urlMd5)).thenReturn(comments);
        when(commentCountService.countEmotionType(comments)).thenReturn(emptyList());
        when(commentCountService.countWords(comments)).thenReturn(emptyList());
        when(commentCountService.filterTop(comments, top)).thenReturn(emptyList());
        when(commentCountService.countDailyComment(comments)).thenReturn(emptyList());
        when(commentCountService.countComment(urlMd5, comments)).thenReturn(emptyList());

        EventComment eventComment = eventCommentService.get(urlMd5);
        EventComment expect = new EventComment();
        expect.setWordCounts(emptyList());
        expect.setCommentEmotionCounts(emptyList());
        expect.setCommentContents(emptyList());
        expect.setDailyCommentCounts(emptyList());
        expect.setCommentCounts(emptyList());
        assertThat(eventComment, is(expect));

        verify(commentCountService).countDailyComment(comments);
        verify(commentCountService).countWords(comments);
        verify(commentCountService).countEmotionType(comments);
        verify(commentCountService).filterTop(comments, top);
        verify(commentCountService).countComment(urlMd5, comments);
    }
}