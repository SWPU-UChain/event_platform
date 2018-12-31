package com.dataht.event.service.impl;

import com.dataht.event.exception.NotFoundException;
import com.dataht.event.model.presistence.HotWord;
import com.dataht.event.repository.HotWordRepository;
import com.dataht.event.service.HotWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotWordServiceImpl implements HotWordService {

    private HotWordRepository hotWordRepository;

    @Autowired
    public HotWordServiceImpl(HotWordRepository hotWordRepository) {
        this.hotWordRepository = hotWordRepository;
    }

    @Override
    public List<String> getNewest() {
        HotWord hotWord = hotWordRepository.findTopByOrderByTimeDesc();
        if (hotWord == null) throw new NotFoundException("hot words not found");
        return hotWord.getWords();
    }
}
