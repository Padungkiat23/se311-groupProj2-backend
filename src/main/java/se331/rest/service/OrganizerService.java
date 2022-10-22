package se331.rest.service;

import org.springframework.data.domain.Page;
import se331.rest.entity.Doctor;

import java.util.List;

public interface OrganizerService {
    List<Doctor> getAllOrganizer();
    Page<Doctor> getOrganizer(Integer page, Integer pageSize);
}

