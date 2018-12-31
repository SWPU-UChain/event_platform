package com.dataht.event.service.inner.impl;

import com.dataht.event.model.presistence.Comment;
import com.dataht.event.model.view.CommentContent;
import com.dataht.event.service.EventService;
import com.dataht.event.service.inner.CommentCountService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CommentCountServiceImplTestForFilterTop {

    private EventService eventService;
    private CommentCountService commentCountService;

    @Before
    public void setUp() throws Exception {
        commentCountService = new CommentCountServiceImpl(eventService);
    }

    @Test
    public void should_return_top_comment_list_when_filter_success() throws Exception {
        List<Comment> comments = buildComments();
        int top = 5;
        List<CommentContent> filterContents = commentCountService.filterTop(comments, top);
        List<CommentContent> commentContents = buildCommentContents();
        assertThat(filterContents, is(commentContents));
    }

    private List<CommentContent> buildCommentContents() {
        List<CommentContent> commentContents = new ArrayList<>();
        CommentContent commentContent1 = new CommentContent();
        commentContent1.setType("happy");
        List<String> commentStrings1 = new ArrayList<>();
        commentStrings1.add("comment2");
        commentStrings1.add("comment1");
        commentContent1.setComments(commentStrings1);
        CommentContent commentContent2 = new CommentContent();
        commentContent2.setType("sad");
        List<String> commentStrings2 = new ArrayList<>();
        commentStrings2.add("comment3");
        commentContent2.setComments(commentStrings2);
        commentContents.add(commentContent2);
        commentContents.add(commentContent1);
        return commentContents;
    }

    private List<Comment> buildComments() {
        List<Comment> comments = new ArrayList<>();
        Comment comment1 = new Comment();
        comment1.setType("happy");
        comment1.setEmotionRsi(23);
        comment1.setContent("comment1");
        Comment comment2 = new Comment();
        comment2.setType("happy");
        comment2.setEmotionRsi(93);
        comment2.setContent("comment2");
        Comment comment3 = new Comment();
        comment3.setType("sad");
        comment3.setEmotionRsi(20);
        comment3.setContent("comment3");
        comments.add(comment1);
        comments.add(comment2);
        comments.add(comment3);
        return comments;
    }
}