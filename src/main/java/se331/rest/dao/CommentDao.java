package se331.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Comment;
import se331.rest.entity.Doctor;

import java.util.Optional;

public interface CommentDao {
    Comment save(Comment comment);
    Page<Comment> getComment(Pageable pageRequest);
    Optional<Comment> findById(Long id);
}
