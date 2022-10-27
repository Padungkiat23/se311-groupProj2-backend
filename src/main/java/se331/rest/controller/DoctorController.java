package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se331.rest.service.DoctorService;
import se331.rest.util.LabMapper;

@RestController
public class DoctorController {

    DoctorService doctorService;

    @GetMapping("/doctors")
    ResponseEntity<?> getDoctors() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getDoctorDTO(doctorService.getAllDoctor()));
    }
}

