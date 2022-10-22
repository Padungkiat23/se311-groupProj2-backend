package se331.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Doctor;

import java.util.Optional;

public interface OrganizerDao {
    Page<Doctor> getOrganizer(Pageable pageRequest);
    Optional<Doctor> findById(Long id);

}

