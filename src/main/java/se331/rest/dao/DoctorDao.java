package se331.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Doctor;

import javax.print.Doc;
import java.util.Optional;

public interface DoctorDao {
    Page<Doctor> getDoctor(Pageable pageRequest);
    Optional<Doctor> findById(Long id);
}
