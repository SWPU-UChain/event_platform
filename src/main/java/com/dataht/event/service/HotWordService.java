package com.dataht.event.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotWordService {

    List<String> getNewest();

}
