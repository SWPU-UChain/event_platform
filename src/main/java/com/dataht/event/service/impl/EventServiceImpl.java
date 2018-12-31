package com.dataht.event.service.impl;

import com.dataht.event.config.CountProperties;
import com.dataht.event.exception.NoEventFoundException;
import com.dataht.event.exception.ParameterException;
import com.dataht.event.model.jsonb.KeyWords;
import com.dataht.event.model.jsonb.RelativeEvent;
import com.dataht.event.model.presistence.Event;
import com.dataht.event.model.view.*;
import com.dataht.event.repository.CommentRepository;
import com.dataht.event.repository.EventRepository;
import com.dataht.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
public class EventServiceImpl implements EventService {

    private static final String HOT = "hot";

    private EventRepository eventRepository;

    private CountProperties countProperties;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository,
                            CountProperties countProperties) {
        this.eventRepository = eventRepository;
        this.countProperties = countProperties;
    }

    @Override
    public Page<PageEvent> getEvents(String standard, String category, int page) {
        //通过dao获取数据库中的event数组
        if (page <= 0) page = 1;
        Page<PageEvent> pageEvents;
        int size = countProperties.getPageCount();
        switch (standard) {
            case "media":
                Pageable pageable = new PageRequest(page - 1, size, DESC, HOT);
                pageEvents = eventRepository.findAllByWebsite(category, pageable);
                break;
            case "type":
                PageRequest pageRequest = new PageRequest(page - 1, size, DESC, HOT);
                pageEvents = eventRepository.findAllByType(category, pageRequest);
                break;
            default:
                throw new ParameterException();
        }
        if (pageEvents == null ) {
            throw new NoEventFoundException();
        }
        return pageEvents;
    }

    private String mapToJsonArrayString(String category) {
        category = "'[\"" + category + "\"]'";
        return category;
    }

    @Override
    public EventDetail getEventDetail(String urlMd5) {
        Event event = eventRepository.findByUrlMd5(urlMd5);
        if (event == null) {
            throw new NoEventFoundException();
        }
        EventDetail eventDetail = new EventDetail(event);
        if (eventDetail.getRelative() != null) {
            eventDetail.setRelative(eventDetail.getRelative().stream()
                    .sorted(comparing(RelativeEvent::getValue).reversed())
                    .limit(countProperties.getRelativeCount())
                    .collect(toList()));
        }
        return eventDetail;
    }

    @Override
    public List<KeyWords> getKeywords(String urlMd5) {
        Event event = eventRepository.findByUrlMd5(urlMd5);
        if (event == null) throw new NoEventFoundException();
        return event.getKeywords();
    }

}
