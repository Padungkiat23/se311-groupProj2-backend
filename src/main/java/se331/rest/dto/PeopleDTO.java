package se331.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.rest.entity.Comment;
import se331.rest.entity.Doctor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeopleDTO {
    Long id;
    String name;
    String surname;
    Long age;
    String hometown;
    String imgUrls;
    DoctorDTO doctor;

    List< PeopleVaccineDTO > vaccines ;
    Boolean vaccinated;
    List<Comment> commentList;

}

