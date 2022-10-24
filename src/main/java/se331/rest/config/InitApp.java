package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.rest.entity.doctor.Doctor;
import se331.rest.entity.patient.People;
import se331.rest.entity.vaccine.Vaccine;
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
        Doctor doc1, doc2;
        doc1 = doctorRepository.save(Doctor.builder().name("Dr.Smith Henry").build());
        doc2 = doctorRepository.save(Doctor.builder().name("Dr.Caitlyn Dow").build());

        // Vaccine configuration
        Vaccine vac1, vac2, vac3;
        vac1 = vaccinatedRepository.save((Vaccine.builder()
                .name("Pfizer").build()));
        vac2 = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").build()));
        vac3 = vaccinatedRepository.save((Vaccine.builder()
                .name("AstraZeneca").build()));

        People tempPeople = null;
        tempPeople = peopleRepository.save(People.builder()
                .name("Vishal")
                .surname("Wilkins")
                .age(21L)
                .hometown("7263 Airport Street Saint Charles, IL 60174")
                .vaccinated(true)
                .vac_date("01/01/2021")
                .build());
        tempPeople.getVaccines().add(vac1);
        doc1.getOwnPeoples().add(tempPeople);

        tempPeople = peopleRepository.save(People.builder()
                .name("Bodhi")
                .surname("Buxton")
                .age(19L)
                .hometown("87 Tailwater Ave. Lawrence, MA 01841")
                .vaccinated(true)
                .vac_date("01/01/2021")
                .build());
        tempPeople.getVaccines().add(vac1);
        doc1.getOwnPeoples().add(tempPeople);

        tempPeople = peopleRepository.save(People.builder()
                .name("Hakim")
                .surname("Schwartz")
                .age(18L)
                .hometown("56 Temple Melrose, MA 02176")
                .vaccinated(true)
                .vac_date("01/02/2021")
                .build());
        tempPeople.getVaccines().add(vac2);
        doc2.getOwnPeoples().add(tempPeople);

        tempPeople = peopleRepository.save(People.builder()
                .name("Ezekiel")
                .surname("Sanchez")
                .age(25L)
                .hometown("316 Belmont Lane Longwood, FL 32779")
                .vaccinated(true)
                .vac_date("01/02/2021")
                .build());
        tempPeople.getVaccines().add(vac3);
        doc2.getOwnPeoples().add(tempPeople);

        tempPeople = peopleRepository.save(People.builder()
                .name("Azir")
                .surname("Kawai")
                .age(25L)
                .hometown("448 West James Long, FL 32779")
                .vaccinated(true)
                .vac_date("01/02/2021")
                .build());
        tempPeople.getVaccines().add(vac3);
        doc1.getOwnPeoples().add(tempPeople);

        tempPeople = peopleRepository.save(People.builder()
                .name("Dom")
                .surname("Dik")
                .age(25L)
                .hometown("784 Green Longwood, FL 32779")
                .vaccinated(true)
                .vac_date("16/02/2021")
                .build());
        tempPeople.getVaccines().add(vac2);
        doc1.getOwnPeoples().add(tempPeople);

        tempPeople = peopleRepository.save(People.builder()
                .name("Raberd")
                .surname("Veyla")
                .age(30L)
                .hometown("857 Prairie Drive Reynoldsburg, OH 43068")
                .vaccinated(true)
                .vac_date("28/02/2021")
                .build());
        tempPeople.getVaccines().add(vac3);
        doc1.getOwnPeoples().add(tempPeople);

        tempPeople = peopleRepository.save(People.builder()
                .name("Caitlin")
                .surname("Schneider")
                .age(30L)
                .hometown("9259 James Cantonment, FL 11533")
                .vaccinated(true)
                .vac_date("16/02/2021")
                .build());
        tempPeople.getVaccines().add(vac3);
        doc2.getOwnPeoples().add(tempPeople);

        tempPeople = peopleRepository.save(People.builder()
                .name("Wong")
                .surname("Asiyah")
                .age(32L)
                .hometown("17 Birchpond St. Bethesda, MD 20814")
                .vaccinated(true)
                .vac_date("14/05/2021")
                .build());
        tempPeople.getVaccines().add(vac1);
        doc1.getOwnPeoples().add(tempPeople);

        tempPeople = peopleRepository.save(People.builder()
                .name("Hashim")
                .surname("Melton")
                .age(33L)
                .hometown("263 St Louis St. Miami Gardens, FL 3305")
                .vaccinated(true)
                .vac_date("19/05/2021")
                .build());
        tempPeople.getVaccines().add(vac1);
        doc2.getOwnPeoples().add(tempPeople);

        tempPeople = peopleRepository.save(People.builder()
                .name("Judy")
                .surname("Metcalfer")
                .age(28L)
                .hometown("59 Nichols Street Alliance, OH 44601")
                .vaccinated(true)
                .vac_date("28/05/2021")
                .build());
        tempPeople.getVaccines().add(vac3);
        doc2.getOwnPeoples().add(tempPeople);

        tempPeople = peopleRepository.save(People.builder()
                .name("John-Paul")
                .surname("Villa")
                .age(27L)
                .hometown("30500 Chiang Mai Thailand")
                .vaccinated(true)
                .vac_date("11/06/2021")
                .build());
        tempPeople.getVaccines().add(vac2);
        doc2.getOwnPeoples().add(tempPeople);

        tempPeople = peopleRepository.save(People.builder()
                .name("Eshal")
                .surname("Villa")
                .age(25L)
                .hometown("14475 North Street hometown, IT 66554")
                .vaccinated(true)
                .vac_date("11/06/2021")
                .build());
        tempPeople.getVaccines().add(vac2);
        doc2.getOwnPeoples().add(tempPeople);

        tempPeople = peopleRepository.save(People.builder()
                .name("Julian")
                .surname("Rollins")
                .age(39L)
                .hometown("3322 Hillcrest IO 55474")
                .vaccinated(true)
                .vac_date("02/07/2021")
                .build());
        tempPeople.getVaccines().add(vac3);
        doc1.getOwnPeoples().add(tempPeople);

        tempPeople = peopleRepository.save(People.builder()
                .name("Thompson")
                .surname("Merritt")
                .age(42L)
                .hometown("162 Chestnut Ave. Marquette, MI 49855")
                .vaccinated(true)
                .vac_date("12/08/2021")
                .build());
        tempPeople.getVaccines().add(vac3);
        doc2.getOwnPeoples().add(tempPeople);

        addUser();
        tempPeople.setUser(patient);
        doc1.setUser(doctor);
        doc2.setUser(doctor);
        patient.setPatient(tempPeople);
        doctor.setDoctor(doc1);
        doctor.setDoctor(doc2);
        // completed add user and role of user
    }
        // Authority configuration
        // Doctor is an admin, Patient is a user, Neither are disableUser
        User admin, doctor, patient;
    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
        Authority authAdmin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        Authority authDoctor = Authority.builder().name(AuthorityName.ROLE_DOCTOR).build();
        Authority authPatient = Authority.builder().name(AuthorityName.ROLE_PATIENT).build();

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
                .email("doctor@doctor.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        patient = User.builder()
                .username("patient")
                .password(encoder.encode("patient"))
                .firstname("patient")
                .lastname("patient")
                .email("patient@patient.com")
                .enabled(false)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        authorityRepository.save(authUser);
        authorityRepository.save(authAdmin);
        admin.getAuthorities().add(authAdmin); // user1 is admin
        doctor.getAuthorities().add(authDoctor); // user2 is doctor
        patient.getAuthorities().add(authPatient); //user3 is patient
        userRepository.save(admin);
        userRepository.save(doctor);
        userRepository.save(patient);
    }
}
