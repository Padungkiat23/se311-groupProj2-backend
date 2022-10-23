package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import se331.rest.entity.Doctor;
import se331.rest.service.DoctorService;
import se331.rest.util.LabMapper;

public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping("/doctor")
    ResponseEntity<?> getDoctors() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getDoctorDTO((Doctor) doctorService.getAllDoctor()));
    }
}
