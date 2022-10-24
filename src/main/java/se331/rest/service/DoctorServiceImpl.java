package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import se331.rest.dao.DoctorDao;
import se331.rest.entity.Doctor;

import java.util.List;

public class DoctorServiceImpl {
    @Autowired
    DoctorDao doctorDao;

    public List<Doctor> getAllDoctor() {
        return doctorDao.getDoctor(Pageable.unpaged()).getContent();
    }
}
