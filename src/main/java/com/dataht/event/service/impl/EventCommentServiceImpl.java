package com.dataht.event.service.impl;

import com.dataht.event.config.CountProperties;
import com.dataht.event.exception.NoCommentException;
import com.dataht.event.exception.NotFoundException;
import com.dataht.event.model.presistence.Comment;
import com.dataht.event.model.view.EventComment;
import com.dataht.event.repository.CommentRepository;
import com.dataht.event.service.EventCommentService;
import com.dataht.event.service.inner.CommentCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventCommentServiceImpl implements EventCommentService {

    private CommentRepository commentRepository;
    private CommentCountService commentCountService;
    private CountProperties countProperties;

    @Autowired
    public EventCommentServiceImpl(CommentRepository commentRepository,
                                   CommentCountService commentCountService,
                                   CountProperties countProperties) {
        this.commentRepository = commentRepository;
        this.commentCountService = commentCountService;
        this.countProperties = countProperties;
    }

    @Override
    public EventComment get(String urlMd5) {
        List<Comment> comments = commentRepository.findAllByUrlMd5(urlMd5);
        if (comments == null || comments.isEmpty()) {
            throw new NoCommentException();
        }
        EventComment eventComment = new EventComment();
        eventComment.setCommentEmotionCounts(commentCountService.countEmotionType(comments));
        eventComment.setCommentContents(
                commentCountService.filterTop(comments, countProperties.getCommentCount()));
        eventComment.setWordCounts(commentCountService.countWords(comments));
        eventComment.setDailyCommentCounts(commentCountService.countDailyComment(comments));
        eventComment.setCommentCounts(commentCountService.countComment(urlMd5, comments));
        return eventComment;
    }

}
