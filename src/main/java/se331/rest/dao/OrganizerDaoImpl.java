package se331.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Doctor;
import se331.rest.repository.OrganizerRepository;

import java.util.Optional;

@Repository
public class OrganizerDaoImpl implements OrganizerDao {
    @Autowired
    OrganizerRepository organizerRepository;

    @Override
    public Page<Doctor> getOrganizer(Pageable pageRequest) {
        return organizerRepository.findAll(pageRequest);
    }

    @Override

    public Optional<Doctor> findById(Long id) {
         return organizerRepository.findById(id);

    }

}

