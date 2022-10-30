package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.rest.entity.People;
import se331.rest.security.entity.User;
import se331.rest.security.service.UserService;
import se331.rest.service.PeopleService;
import se331.rest.util.LabMapper;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<?> getUserList(@RequestParam(value = "_limit", required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page
            , @RequestParam(value = "title", required = false) String title) {
        perPage = perPage == null ? 6 : perPage;
        page = page == null ? 1 : page;
        Page<User> pageOutput;
//        if (title == null) {
            pageOutput = userService.getUser(perPage, page);
//        } else {
//            pageOutput = userService.getUsers(title, PageRequest.of(page - 1, perPage));
//        }
        HttpHeaders responseHeader = new HttpHeaders();

        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getUserDto(pageOutput.getContent()), responseHeader, HttpStatus.OK);


    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        User output = userService.getUser(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        User output = userService.save(user);
        return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(output));
    }

}



