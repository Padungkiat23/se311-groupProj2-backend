package se331.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.People;

public interface EventDao {
    Integer getPeopleSize();
    Page<People> getPeoples(Integer pageSize, Integer page);
    People getEvents(Long id);

    People save(People people);
    Page<People> getEvents(String name, Pageable page);
}

