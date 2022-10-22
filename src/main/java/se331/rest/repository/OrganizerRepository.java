package se331.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.rest.entity.Doctor;

public interface OrganizerRepository extends JpaRepository<Doctor,Long> {
}

