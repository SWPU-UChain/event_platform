package com.dataht.event.service.inner.impl;

import com.dataht.event.exception.NoEventFoundException;
import com.dataht.event.model.presistence.Comment;
import com.dataht.event.model.view.*;
import com.dataht.event.service.EventService;
import com.dataht.event.service.inner.CommentCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
public class CommentCountServiceImpl implements CommentCountService {

    private EventService eventService;

    @Value("${event.service.timeStamp}")
    private Long timeStamp;

    @Autowired
    public CommentCountServiceImpl(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public List<CommentEmotionCount> countEmotionType(List<Comment> comments) {
        Map<String, Long> emotionCountMap = comments.stream().collect(groupingBy(Comment::getType, counting()));
        ArrayList<CommentEmotionCount> emotionCounts = new ArrayList<>();
        emotionCountMap.forEach((type, count) -> emotionCounts.add(new CommentEmotionCount(type, count)));
        emotionCounts.sort(comparing(CommentEmotionCount::getCount).reversed());
        return emotionCounts;
    }

    @Override
    public List<WordCount> countWords(List<Comment> comments) {
        Map<String, Long> countMap = comments.stream()
                .flatMap(comment -> comment.getWords().stream())
                .collect(groupingBy(word -> word, counting()));
        List<WordCount> wordCounts = new ArrayList<>();
        countMap.forEach((word, count) -> wordCounts.add(new WordCount(word, count.intValue())));
        wordCounts.sort(comparing(WordCount::getCount).reversed());
        return wordCounts;
    }

    @Override
    public List<CommentContent> filterTop(List<Comment> comments, int top) {
        List<CommentContent> commentContents = new ArrayList<>();
        comments.stream().collect(groupingBy(Comment::getType))
                .forEach((type, commentList) -> {
                    List<String> collect = commentList.stream()
                            .sorted(comparing(Comment::getEmotionRsi).reversed())
                            .limit(top)
                            .map(Comment::getContent)
                            .distinct()
                            .collect(toList());
                    commentContents.add(new CommentContent(type, collect));
                });
        return commentContents;
    }

    @Override
    public List<DailyCommentCount> countDailyComment(List<Comment> comments) {
        List<DailyCommentCount> dailyCommentCounts = new ArrayList<>();
        comments.stream().collect(groupingBy(Comment::getTime, counting()))
                .forEach((time, count) -> {
            dailyCommentCounts.add(new DailyCommentCount(time, count.intValue()));
                });
        dailyCommentCounts.sort(comparing(DailyCommentCount::getCount).reversed());
        return dailyCommentCounts;
    }

    public List<CommentCount> countComment(String urlMd5, List<Comment> comments) {
        List<CommentCount> commentCounts = new ArrayList<>();
        List<DailyCommentCount> dailyCommentCounts = new ArrayList<>();
        EventDetail eventDetail = eventService.getEventDetail(urlMd5);
        if (eventDetail == null) {
            throw new NoEventFoundException();
        }
        Long eventTime = eventDetail.getTime();
        comments.stream().collect(groupingBy(Comment::getTime, counting()))
                .forEach((time, count) -> {
                    dailyCommentCounts.add(new DailyCommentCount(time, count.intValue()));
                });
        for (int i = 0; i < 48; i++) {
            int commentCount = 0;
            for (DailyCommentCount dailyCommentCount : dailyCommentCounts) {
                if (dailyCommentCount.getTime() >= eventTime
                        && dailyCommentCount.getTime() < eventTime + timeStamp) {
                    commentCount += dailyCommentCount.getCount();
                }
            }
            eventTime += timeStamp;
            commentCounts.add(new CommentCount(eventTime, commentCount));

        }
        return commentCounts;
    }
}
