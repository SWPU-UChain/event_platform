package com.dataht.event.service.inner.impl;

import com.dataht.event.model.presistence.Comment;
import com.dataht.event.model.view.DailyCommentCount;
import com.dataht.event.service.EventService;
import com.dataht.event.service.inner.CommentCountService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CommentCountServiceImplTestForCountDailyComment {

    private EventService eventService;
    private CommentCountService commentCountService;

    @Before
    public void setUp() throws Exception {
        commentCountService = new CommentCountServiceImpl(eventService);
    }

    @Test
    public void should_return_count_list_when_count_success() throws Exception {
        List<Comment> comments = Stream.of(1, 2, 3, 5, 3, 5, 2, 3, 3, 1, 2)
                .map(time -> {
                    Comment comment = new Comment();
                    comment.setTime(time.longValue());
                    return comment;
                }).collect(toList());
        List<DailyCommentCount> dailyCommentCounts =
                commentCountService.countDailyComment(comments);
        List<DailyCommentCount> expect = Stream
                .of(new DailyCommentCount(3L, 4), new DailyCommentCount(2L, 3),
                        new DailyCommentCount(1L, 2), new DailyCommentCount(5L, 2))
                .collect(toList());
        assertThat(dailyCommentCounts, is(expect));
    }
}