package se331.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.rest.entity.doctor.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
