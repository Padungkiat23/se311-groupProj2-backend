package se331.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.rest.entity.Participant;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorOwnPeopleDTO {
    Long id;
    String name;
    String surname;
    Long age;
    String hometown;
    Boolean vaccinated;
    String imgUrls;
}
