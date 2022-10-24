package se331.rest.entity.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.rest.entity.doctor.DoctorDTO;
import se331.rest.security.entity.UserDTO;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeopleDTO {
    Long id;
    UserDTO userDTO;
    DoctorDTO doctorDTO;
    List<HistoryVaccineDTO> historyVaccineDTOList;
//    List<CommentDTO> commentDTOS;
}

