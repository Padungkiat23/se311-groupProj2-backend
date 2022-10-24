package se331.rest.entity.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.rest.entity.Participant;
import se331.rest.entity.vaccine.dto.VaccineDTO;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryVaccineDTO {
    VaccineDTO vaccineDTO;
    String vaccineDate;
}

