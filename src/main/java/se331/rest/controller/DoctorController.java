package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.rest.entity.Doctor;
import se331.rest.entity.People;
import se331.rest.service.DoctorService;
import se331.rest.util.LabMapper;

@RestController
public class DoctorController {

    DoctorService doctorService;

    @GetMapping("/doctors")
    ResponseEntity<?> getDoctors() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getDoctorDto(doctorService.getAllDoctor()));
    }

//    @GetMapping("/doctors")
//    public ResponseEntity<?> getDoctors(@RequestParam(value = "_limit", required = false) Integer perPage
//            , @RequestParam(value = "_page", required = false) Integer page
//            , @RequestParam(value = "title", required = false) String title) {
//        perPage = perPage == null ? 6 : perPage;
//        page = page == null ? 1 : page;
//        Page<People> pageOutput;
//        if (title == null) {
//            pageOutput = peopleService.getPeoples(perPage, page);
//        } else {
//            pageOutput = peopleService.getPeoples(title, PageRequest.of(page - 1, perPage));
//        }
//        HttpHeaders responseHeader = new HttpHeaders();
//
//        return ResponseEntity.ok(LabMapper.INSTANCE.getDoctorDTO(doctorService.getAllDoctor()));
//    }

    @GetMapping("doctor/{id}")
    public ResponseEntity<?> getDoctor(@PathVariable("id") Long id) {
        Doctor output = doctorService.getDoctor(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getDoctorDto(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/doctor")
    public ResponseEntity<?> addPeople(@RequestBody Doctor doctor) {
        Doctor output = doctorService.save(doctor);
        return ResponseEntity.ok(LabMapper.INSTANCE.getDoctorDto(output));
    }
}

