package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import se331.rest.entity.Comment;
import se331.rest.entity.People;
import se331.rest.service.CommentService;
import se331.rest.service.PeopleService;
import se331.rest.util.LabMapper;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    PeopleService peopleService;

    @GetMapping("/comments")
    ResponseEntity<?> getComments() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDto(commentService.getAllComment()));
    }

    @PostMapping("/comment/people/{id}")
    ResponseEntity<?> addComment(@PathVariable("id") Long id,@RequestBody Comment comment){
        People output_id = peopleService.getPeople(id);
        output_id.getCommentList().add(comment);
        Comment output = commentService.save(comment);
        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDto(output));
    }
}
