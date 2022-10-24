package se331.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.rest.entity.vaccine.Vaccine;
import se331.rest.repository.VaccinatedRepository;

import java.util.Optional;

@Repository
public class VaccineDaoImpl implements VaccineDao {
    @Autowired
    VaccinatedRepository vaccinatedRepository;

    @Override
    public Page<Vaccine> getVaccine(Pageable pageRequest) {
        return vaccinatedRepository.findAll(pageRequest);
    }

    @Override

    public Optional<Vaccine> findById(Long id) {
         return vaccinatedRepository.findById(id);

    }

}

