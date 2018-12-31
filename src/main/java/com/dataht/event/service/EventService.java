package com.dataht.event.service;

import com.dataht.event.model.jsonb.KeyWords;
import com.dataht.event.model.view.PageEvent;
import com.dataht.event.model.view.EventDetail;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EventService {

    Page<PageEvent> getEvents(String standard, String category, int page);

    EventDetail getEventDetail(String urlMd5);

    List<KeyWords> getKeywords(String urlMd5);
}
