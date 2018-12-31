package com.dataht.event.service.inner;

import com.dataht.event.model.presistence.Comment;
import com.dataht.event.model.view.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentCountService {

    List<CommentEmotionCount> countEmotionType(List<Comment> comments);

    List<WordCount> countWords(List<Comment> comments);

    List<CommentContent> filterTop(List<Comment> comments, int top);

    List<DailyCommentCount> countDailyComment(List<Comment> comments);

    List<CommentCount> countComment(String urlMd5, List<Comment> comments);

}
