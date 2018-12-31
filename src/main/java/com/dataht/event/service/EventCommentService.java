package com.dataht.event.service;

import com.dataht.event.model.view.EventComment;
import org.springframework.stereotype.Service;

@Service
public interface EventCommentService {

    EventComment get(String urlMd5);

}
