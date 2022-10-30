package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se331.rest.entity.People;
import se331.rest.entity.Vaccine;
import se331.rest.service.PeopleService;
import se331.rest.service.VaccineService;
import se331.rest.util.LabMapper;

@RestController
public class VaccinationController {
    @Autowired
    VaccineService vaccineService;

    @GetMapping("/vaccines")
    ResponseEntity<?> getOrganizers() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getVaccineDTO(vaccineService.getAllVaccine()));
    }

    @Autowired
    PeopleService peopleService;


    @PostMapping("/vaccine/people/{id}")
    ResponseEntity<?> addComment(@PathVariable("id") Long id, @RequestBody Vaccine vaccine){
        People output = peopleService.getPeople(id);
        output.getVaccines().add(vaccine);
        Vaccine output2 = vaccineService.save(vaccine);
        return ResponseEntity.ok(LabMapper.INSTANCE.getVaccineDTO(output2));
    }
}
