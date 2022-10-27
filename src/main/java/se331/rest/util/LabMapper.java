package se331.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.rest.entity.*;
import se331.rest.security.entity.User;
import se331.rest.security.entity.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    PeopleDTO getPeopleDto(People people);
    UserDTO getUserDTO(User user);
    List<PeopleDTO> getPeopleDto(List<People> people);
    VaccineDTO getVaccineDTO(Vaccine vaccine);
    List<VaccineDTO> getVaccineDTO(List<Vaccine> vaccines);
    DoctorDTO getDoctorDTO(Doctor doctor);
    List<DoctorDTO> getDoctorDTO(List<Doctor> doctors);

//    @Mapping(target = "authorities", expression = "java(organizer.getUser().getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
//    DoctorAuthDTO getOrganizerAuthDTO(Vaccine vaccine);

    @Mapping(target = "authorities", source = "user.authorities")
    DoctorAuthDTO getDoctorAuthDTO(Doctor doctor);

}