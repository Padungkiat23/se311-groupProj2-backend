package se331.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Comment;
import se331.rest.repository.CommentRepository;

import java.util.Optional;

public class CommentDaoImpl implements CommentDao {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment){
        return  commentRepository.save(comment);
    }

    @Override
    public Page<Comment> getComment(Pageable pageRequest) {
        return commentRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }
}

