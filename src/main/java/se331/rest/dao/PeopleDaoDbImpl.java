package se331.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.rest.entity.patient.People;
import se331.rest.repository.PeopleRepository;

@Profile("db")
@Repository
public class PeopleDaoDbImpl implements PeopleDao {
    @Autowired
    PeopleRepository peopleRepository;

    @Override
    public Integer getPeopleSize() {
        return Math.toIntExact(peopleRepository.count());
    }

    @Override
    public Page<People> getPeoples(Integer pageSize, Integer page) {
        return peopleRepository.findAll(PageRequest.of(page-1,pageSize));
    }

    @Override
    public People getEvents(Long id) {
        return peopleRepository.findById(id).orElse(null);
    }

    @Override
    public People save(People people) {
        return peopleRepository.save(people);
    }

    @Override
    public Page<People> getEvents(String name, Pageable page) {
        return peopleRepository.findByName(name,page);
    }
}
