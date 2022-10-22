package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.rest.dao.EventDao;
import se331.rest.dao.OrganizerDao;
import se331.rest.entity.People;
import se331.rest.entity.Doctor;

import javax.transaction.Transactional;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    EventDao eventDao;

    @Autowired
    OrganizerDao organizerDao;

    @Override
    public Integer getPeopleSize() {
        return eventDao.getPeopleSize();
    }

    @Override
    public Page<People> getPeoples(Integer pageSize, Integer page) {
        return eventDao.getPeoples(pageSize, page);
    }

    @Override
    public People getEvent(Long id) {
        return eventDao.getEvents(id);
    }

    @Override
    @Transactional
    public People save(People people) {
        Doctor doctor = organizerDao.findById(people.getDoctor().getId()).orElse(null);
        people.setDoctor(doctor);
        doctor.getOwnPeople().add(people);

        return eventDao.save(people);
    }

    @Override
    public Page<People> getEvents(String title, Pageable pageable) {
        return eventDao.getEvents(title,pageable);
    }
}

