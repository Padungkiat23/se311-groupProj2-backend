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
import se331.rest.entity.patient.People;
import se331.rest.service.PeopleService;
import se331.rest.util.LabMapper;

@Controller
public class PeopleController {


    @Autowired
    PeopleService peopleService;

    @GetMapping("people")
    public ResponseEntity<?> getPeopleList(@RequestParam(value = "_limit", required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page
            , @RequestParam(value = "title", required = false) String title) {
        perPage = perPage == null ? 6 : perPage;
        page = page == null ? 1 : page;
        Page<People> pageOutput;
        if (title == null) {
            pageOutput = peopleService.getPeoples(perPage, page);
        } else {
            pageOutput = peopleService.getPeoples(title, PageRequest.of(page - 1, perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();

        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getPeopleDto(pageOutput.getContent()), responseHeader, HttpStatus.OK);


    }

    @GetMapping("people/{id}")
    public ResponseEntity<?> getPeople(@PathVariable("id") Long id) {
        People output = peopleService.getPeople(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getPeopleDto(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/people")
    public ResponseEntity<?> addPeople(@RequestBody People people) {
        People output = peopleService.save(people);
        return ResponseEntity.ok(LabMapper.INSTANCE.getPeopleDto(output));
    }

}



