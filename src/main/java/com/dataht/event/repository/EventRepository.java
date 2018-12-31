package com.dataht.event.repository;

import com.dataht.event.model.presistence.Event;
import com.dataht.event.model.view.PageEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    Page<PageEvent> findAllByType(String type, Pageable pageable);

    Page<PageEvent> findAllByWebsite(String website, Pageable pageable);

    Event findByUrlMd5(String urlMd5);
}
