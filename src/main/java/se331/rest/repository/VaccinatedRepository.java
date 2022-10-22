package se331.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.rest.entity.Vaccine;

public interface VaccinatedRepository extends JpaRepository<Vaccine,Long> {
}

