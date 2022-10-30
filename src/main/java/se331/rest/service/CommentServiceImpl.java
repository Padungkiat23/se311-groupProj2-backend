package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.rest.dao.CommentDao;
import se331.rest.entity.Comment;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentDao commentDao;

    public Comment save(Comment comment) {
        return  commentDao.save(comment);
    }
    public List<Comment> getAllComment() {
        return commentDao.getComment(Pageable.unpaged()).getContent();
    }

}
