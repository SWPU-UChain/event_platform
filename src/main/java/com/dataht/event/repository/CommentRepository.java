package com.dataht.event.repository;

import com.dataht.event.model.presistence.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    List<Comment> findAllByUrlMd5(String urlMd5);

}
