package se331.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Admin;
import se331.rest.entity.Doctor;
import se331.rest.entity.People;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctor();
    Page<Doctor> getDoctor(Integer perPage, Integer page);
    Doctor getDoctor(Long id);

    Doctor save(Doctor doctor);
}
