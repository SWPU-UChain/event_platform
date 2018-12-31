package com.dataht.event.controller;

import com.dataht.event.exception.NoEventFoundException;
import com.dataht.event.model.jsonb.KeyWords;
import com.dataht.event.model.view.EventDetail;
import com.dataht.event.service.EventService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static java.net.URLEncoder.encode;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("dev")
public class EventControllerTest {

    @MockBean
    private EventService service;

    @Autowired
    private EventController controller;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void should_response_200_when_get_event_success() throws Exception {
        String id = "id";
        EventDetail expectedValue = new EventDetail();
        when(service.getEventDetail(id)).thenReturn(expectedValue);

        String url = "/event/" + id;
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(expectedValue));
    }

    @Test
    public void should_response_404_when_event_not_found() throws Exception {
        String id = "id";

        when(service.getEventDetail(id)).thenThrow(new NoEventFoundException());

        String url = "/event/" + id;
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNotFound());
    }

    @Test
    public void should_response_200_when_get_keywords_success() throws Exception {
        String urlMd5 = "urlMd5";
        List<KeyWords> keywords = Collections.emptyList();
        when(service.getKeywords(urlMd5)).thenReturn(keywords);
        String path = String.format("/event/%s/keywords", urlMd5);
        mockMvc.perform(MockMvcRequestBuilders.get(path)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    public void should_response_404_when_get_keywords_but_event_not_found() throws Exception {
        String urlMd5 = "urlMd5";
        when(service.getKeywords(urlMd5)).thenThrow(new NoEventFoundException());
        String path = String.format("/event/%s/keywords", urlMd5);
        mockMvc.perform(MockMvcRequestBuilders.get(path)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNotFound());
    }
}