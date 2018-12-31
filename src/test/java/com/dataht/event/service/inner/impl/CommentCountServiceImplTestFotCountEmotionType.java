package com.dataht.event.service.inner.impl;

import com.dataht.event.model.presistence.Comment;
import com.dataht.event.model.view.CommentEmotionCount;
import com.dataht.event.service.EventService;
import com.dataht.event.service.inner.CommentCountService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CommentCountServiceImplTestFotCountEmotionType {

    private EventService eventService;
    private CommentCountService commentCountService;

    @Before
    public void setUp() throws Exception {
        commentCountService = new CommentCountServiceImpl(eventService);
    }

    @Test
    public void should_return_counted_list_when_given_comments() throws Exception {
        String[] types = {"happy", "sad", "happy", "happy", "normal", "sad"};
        List<Comment> comments = Stream.of(types).map(type -> {
            Comment comment = new Comment();
            comment.setType(type);
            return comment;
        }).collect(toList());
        List<CommentEmotionCount> countList = new ArrayList<>();
        countList.add(new CommentEmotionCount("happy", 3));
        countList.add(new CommentEmotionCount("sad", 2));
        countList.add(new CommentEmotionCount("normal", 1));
        List<CommentEmotionCount> actual = commentCountService.countEmotionType(comments);
        assertThat(actual, is(countList));
    }
}