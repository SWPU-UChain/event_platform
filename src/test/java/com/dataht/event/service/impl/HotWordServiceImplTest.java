package com.dataht.event.service.impl;

import com.dataht.event.exception.NotFoundException;
import com.dataht.event.model.presistence.HotWord;
import com.dataht.event.repository.HotWordRepository;
import com.dataht.event.service.HotWordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class HotWordServiceImplTest {

    @MockBean
    private HotWordRepository hotWordRepository;

    @Autowired
    private HotWordService hotWordService;

    @Test
    public void should_return_newest_hot_words() throws Exception {
        HotWord hotWord = mock(HotWord.class);
        List<String> hotWordStrList = Collections.emptyList();
        when(hotWord.getWords()).thenReturn(hotWordStrList);
        when(hotWordRepository.findTopByOrderByTimeDesc()).thenReturn(hotWord);
        List<String> actual = hotWordService.getNewest();
        assertThat(actual, is(hotWordStrList));
    }

    @Test(expected = NotFoundException.class)
    public void should_throw_NotFoundException_when_no_hot_words_found() throws Exception {
        when(hotWordRepository.findTopByOrderByTimeDesc()).thenReturn(null);
        hotWordService.getNewest();
    }
}