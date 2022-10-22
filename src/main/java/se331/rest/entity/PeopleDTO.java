package se331.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    Boolean vaccinated;
    PeopleVaccineDTO vaccineDTO;
    List<String> imageUrls;
}

