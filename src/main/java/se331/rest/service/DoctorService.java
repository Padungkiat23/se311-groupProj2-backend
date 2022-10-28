package se331.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctor();
    Page<Doctor> getDoctor(Integer page, Integer pageSize);
    Page<Doctor> getDoctor(String title, Pageable pageable);
    Doctor getDoctor(Long id);

    Doctor save(Doctor doctor);
}
