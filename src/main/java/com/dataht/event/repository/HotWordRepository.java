package com.dataht.event.repository;

import com.dataht.event.model.presistence.HotWord;
import org.springframework.data.repository.CrudRepository;

public interface HotWordRepository extends CrudRepository<HotWord, Long> {

    HotWord findTopByOrderByTimeDesc();

}
