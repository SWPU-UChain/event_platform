package com.dataht.event.service.inner.impl;

import com.dataht.event.model.presistence.Comment;
import com.dataht.event.model.view.WordCount;
import com.dataht.event.service.EventService;
import com.dataht.event.service.inner.CommentCountService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CommentCountServiceImplTestForCountWords {

    private EventService eventService;
    private CommentCountService commentCountService;

    @Before
    public void setUp() throws Exception {
        commentCountService = new CommentCountServiceImpl(eventService);
    }

    @Test
    public void should_return_word_count_list_when_count_success() throws Exception {
        List<Comment> comments = Stream
                .of(asList("a", "b"), asList("c", "b", "b"), asList("d", "c", "d"), asList("d", "f", "b"))
                .map(words -> {
                    Comment comment = new Comment();
                    comment.setWords(words);
                    return comment;
                }).collect(toList());
        List<WordCount> expectWordCountList = Stream
                .of(new WordCount("a", 1), new WordCount("b", 4), new WordCount("c", 2),
                        new WordCount("d", 3), new WordCount("f", 1))
                .sorted(Comparator.comparing(WordCount::getCount).reversed())
                .collect(toList());
        List<WordCount> wordCounts = commentCountService.countWords(comments);
        assertThat(wordCounts, is(expectWordCountList));
    }
}