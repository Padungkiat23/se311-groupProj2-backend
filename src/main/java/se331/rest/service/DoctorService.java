package se331.rest.service;

import org.springframework.data.domain.Page;
import se331.rest.entity.doctor.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctor();
    Page<Doctor> getDoctor(Integer page, Integer pageSize);
}
