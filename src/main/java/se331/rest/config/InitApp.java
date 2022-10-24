package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.rest.entity.Doctor;
import se331.rest.entity.People;
import se331.rest.entity.Vaccine;
import se331.rest.repository.DoctorRepository;
import se331.rest.repository.PeopleRepository;
import se331.rest.repository.VaccinatedRepository;
import se331.rest.security.entity.Authority;
import se331.rest.security.entity.AuthorityName;
import se331.rest.security.entity.User;
import se331.rest.security.repository.AuthorityRepository;
import se331.rest.security.repository.UserRepository;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    PeopleRepository peopleRepository;
    @Autowired
    VaccinatedRepository vaccinatedRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    @Transactional

    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Doctor doc1, doc2,doc3;
        doc1 = doctorRepository.save(Doctor.builder().name("Dr.Smith Henry").build());
        doc2 = doctorRepository.save(Doctor.builder().name("Dr.Caitlyn Dow").build());
        Vaccine vaccine = null;

        // Vaccine configuration
//        Vaccine vac1, vac2, vac3;
//        vac1 = vaccinatedRepository.save((Vaccine.builder()
//                .name("Pfizer").build()));
//        vac2 = vaccinatedRepository.save((Vaccine.builder()
//                .name("Moderna").build()));
//        vac3 = vaccinatedRepository.save((Vaccine.builder()
//                .name("AstraZeneca").build()));

        People tempPeople = null;
        tempPeople = peopleRepository.save(People.builder()
                .name("Kiki")
                .surname("Eazyi")
                .age(22L)
                .hometown("Bandon")
                .vaccinated(true)
                .build());
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Pfizer").build()));
                tempPeople.getVaccines().add(vaccine);
                tempPeople.setVac_date("January 22, 2021");
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").build()));
                tempPeople.getVaccines().add(vaccine);
                tempPeople.setVac_date("March 22, 2021");

        tempPeople = peopleRepository.save(People.builder()
                .name("Payrai")
                .surname("Najar")
                .age(23L)
                .hometown("7Saint Charles")
                .vaccinated(true)
                .build());
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Pfizer").build()));
                tempPeople.getVaccines().add(vaccine);
                tempPeople.setVac_date("January 22, 2021");
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").build()));


        tempPeople = peopleRepository.save(People.builder()
                .name("Vasaz")
                .surname("Gizar")
                .age(21L)
                .hometown("Ionian river")
                .vaccinated(true)
                .build());
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Pfizer").build()));
                tempPeople.getVaccines().add(vaccine);
                tempPeople.setVac_date("January 22, 2021");
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").build()));
                tempPeople.getVaccines().add(vaccine);
                tempPeople.setVac_date("March 22, 2021");

        tempPeople = peopleRepository.save(People.builder()
                .name("Zed")
                .surname("Shadow")
                .age(25L)
                .hometown("Bearer Iron")
                .vaccinated(true)
                .build());
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Pfizer").build()));
                tempPeople.getVaccines().add(vaccine);
                tempPeople.setVac_date("January 22, 2021");
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").build()));
                tempPeople.getVaccines().add(vaccine);
                tempPeople.setVac_date("March 22, 2021");

        tempPeople = peopleRepository.save(People.builder()
                .name("Keaw")
                .surname("Sai Nam")
                .age(26L)
                .hometown("Jaicum Furniture")
                .vaccinated(true)
                .build());
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Pfizer").build()));
                tempPeople.getVaccines().add(vaccine);
                tempPeople.setVac_date("January 22, 2021");
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Pfizer").build()));
                tempPeople.getVaccines().add(vaccine);
                tempPeople.setVac_date("March 22, 2021");

        tempPeople = peopleRepository.save(People.builder()
                .name("Affrican")
                .surname("Daze")
                .age(26L)
                .hometown("GG Ionian Stair")
                .vaccinated(true)
                .build());
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").build()));
                tempPeople.getVaccines().add(vaccine);
                tempPeople.setVac_date("January 22, 2021");
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").build()));
                tempPeople.getVaccines().add(vaccine);
                tempPeople.setVac_date("March 22, 2021");

        tempPeople = peopleRepository.save(People.builder()
                .name("Zen")
                .surname("Batsu")
                .age(26L)
                .hometown("Mak kum jai")
                .vaccinated(true)
                .build());
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").build()));
                tempPeople.getVaccines().add(vaccine);
                tempPeople.setVac_date("January 22, 2021");
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").build()));
                tempPeople.getVaccines().add(vaccine);
                tempPeople.setVac_date("March 22, 2021");

        tempPeople = peopleRepository.save(People.builder()
                .name("Maingkhum")
                .surname("Sapanjai")
                .age(26L)
                .hometown("Ban don pha phi")
                .vaccinated(true)
                .build());
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("AstraZeneca").build()));
                tempPeople.getVaccines().add(vaccine);
                tempPeople.setVac_date("January 22, 2021");
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").build()));
                tempPeople.getVaccines().add(vaccine);
                tempPeople.setVac_date("March 22, 2021");

        tempPeople = peopleRepository.save(People.builder()
                .name("Vishal")
                .surname("Wilkins")
                .age(21L)
                .hometown("Airport Street")
                .vaccinated(true)
                .build());
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("AstraZeneca").build()));
                tempPeople.getVaccines().add(vaccine);
                tempPeople.setVac_date("January 22, 2021");
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("AstraZeneca").build()));
                tempPeople.getVaccines().add(vaccine);
                tempPeople.setVac_date("March 22, 2021");

                addUser();
    }
        // Authority configuration
        // Doctor is an admin, Patient is a user, Neither are disableUser
        User admin, doctor, patient;
    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authDoctor = Authority.builder().name(AuthorityName.ROLE_DOCTOR).build();
        Authority authPatient = Authority.builder().name(AuthorityName.ROLE_PATIENT).build();
        Authority authAdmin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        admin = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        doctor = User.builder()
                .username("doctor")
                .password(encoder.encode("doctor"))
                .firstname("doctor")
                .lastname("doctor")
                .email("doctor@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        patient = User.builder()
                .username("patient")
                .password(encoder.encode("patient"))
                .firstname("patient")
                .lastname("patient")
                .email("patient@user.com")
                .enabled(false)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        authorityRepository.save(authPatient);
        authorityRepository.save(authDoctor);
        authorityRepository.save(authAdmin);
        admin.getAuthorities().add(authAdmin); // user1 is admin
        doctor.getAuthorities().add(authDoctor); // user2 is doctor
        patient.getAuthorities().add(authPatient); //user3 is patient
        userRepository.save(admin);
        userRepository.save(doctor);
        userRepository.save(patient);
    }
}
