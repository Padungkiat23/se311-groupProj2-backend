package se331.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Doctor;
import se331.rest.repository.DoctorRepository;

import java.util.Optional;

public class DoctorDaoImpl implements DoctorDao {
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Page<Doctor> getDoctor(Pageable pageRequest) {
        return doctorRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }
}
