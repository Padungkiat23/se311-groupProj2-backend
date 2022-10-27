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
import java.util.List;

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
        addUser();
        Doctor doctor = null;
//        doctor = doctorRepository.save(Doctor.builder()
//                .name("Dr.Smith Henry")
//                .build());
//        Doctor doc1, doc2, doc3;
//        doc1 = doctorRepository.save(Doctor.builder()
//                .name("Dr.Smith Henry")
//                .build());
//        doc1.getOwnPeople().add(doctor);
//        doc2 = doctorRepository.save(Doctor.builder()
//                .name("CMU").build());
//        doc3 = doctorRepository.save(Doctor.builder()
//                .name("ChiangMai").build());
        Vaccine vaccine = null;
        People tempPeople = null;
        tempPeople = peopleRepository.save(People.builder()
                .name("Kiki")
                .surname("Eazyi")
                .age(22L)
                .hometown("Bandon")
                .imgUrls("https://st.depositphotos.com/1269204/1219/i/450/depositphotos_12196477-stock-photo-smiling-men-isolated-on-the.jpg")
                .vaccinated(true)
                .build());
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Pfizer").date("January 1, 2021").build()));
                tempPeople.getVaccines().add(vaccine);
                vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Pfizer").date("March 1, 2021").build()));
                tempPeople.getVaccines().add(vaccine);

                tempPeople.setUser(patient);
                patient.setPeople(tempPeople);

        tempPeople = peopleRepository.save(People.builder()
                .name("Payrai")
                .surname("Najar")
                .age(23L)
                .hometown("7Saint Charles")
                .imgUrls("https://st.depositphotos.com/1269204/1219/i/450/depositphotos_12196477-stock-photo-smiling-men-isolated-on-the.jpg")
                .vaccinated(true)
                .build());
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").date("January 14, 2021").build()));
            tempPeople.getVaccines().add(vaccine);
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").date("March 14, 2021").build()));
            tempPeople.getVaccines().add(vaccine);

            tempPeople.setUser(admin);
            admin.setPeople(tempPeople);

        tempPeople = peopleRepository.save(People.builder()
                .name("Vasaz")
                .surname("Gizar")
                .age(21L)
                .hometown("Ionian river")
                .imgUrls("https://st.depositphotos.com/1269204/1219/i/450/depositphotos_12196477-stock-photo-smiling-men-isolated-on-the.jpg")
                .vaccinated(true)
                .build());
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("AstraZeneca").date("January 14, 2021").build()));
            tempPeople.getVaccines().add(vaccine);
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("AstraZeneca").date("March 14, 2021").build()));
            tempPeople.getVaccines().add(vaccine);


        tempPeople = peopleRepository.save(People.builder()
                .name("Zed")
                .surname("Shadow")
                .age(25L)
                .hometown("Bearer Iron")
                .imgUrls("https://st.depositphotos.com/1269204/1219/i/450/depositphotos_12196477-stock-photo-smiling-men-isolated-on-the.jpg")
                .vaccinated(true)
                .build());
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Pfizer").date("February 7, 2021").build()));
            tempPeople.getVaccines().add(vaccine);
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").date("May 7, 2021").build()));
            tempPeople.getVaccines().add(vaccine);

        tempPeople = peopleRepository.save(People.builder()
                .name("Keaw")
                .surname("Sai Nam")
                .age(26L)
                .hometown("Jaicum Furniture")
                .imgUrls("https://st.depositphotos.com/1269204/1219/i/450/depositphotos_12196477-stock-photo-smiling-men-isolated-on-the.jpg")
                .vaccinated(true)
                .build());
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").date("February 14, 2021").build()));
            tempPeople.getVaccines().add(vaccine);
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").date("April 14, 2021").build()));
            tempPeople.getVaccines().add(vaccine);

        tempPeople = peopleRepository.save(People.builder()
                .name("Affrican")
                .surname("Daze")
                .age(26L)
                .hometown("GG Ionian Stair")
                .imgUrls("https://st.depositphotos.com/1269204/1219/i/450/depositphotos_12196477-stock-photo-smiling-men-isolated-on-the.jpg")
                .vaccinated(true)
                .build());
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("AstraZeneca").date("April 26, 2021").build()));
            tempPeople.getVaccines().add(vaccine);
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Pfizer").date("June 26, 2021").build()));
            tempPeople.getVaccines().add(vaccine);

        tempPeople = peopleRepository.save(People.builder()
                .name("Zen")
                .surname("Batsu")
                .age(26L)
                .hometown("Mak kum jai")
                .imgUrls("https://st.depositphotos.com/1269204/1219/i/450/depositphotos_12196477-stock-photo-smiling-men-isolated-on-the.jpg")
                .vaccinated(true)
                .build());
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Pfizer").date("May 14, 2021").build()));
            tempPeople.getVaccines().add(vaccine);
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Pfizer").date("July 14, 2021").build()));
            tempPeople.getVaccines().add(vaccine);

        tempPeople = peopleRepository.save(People.builder()
                .name("Maing")
                .surname("Sapanjai")
                .age(26L)
                .hometown("Ban don pha phi")
                .imgUrls("https://st.depositphotos.com/1269204/1219/i/450/depositphotos_12196477-stock-photo-smiling-men-isolated-on-the.jpg")
                .vaccinated(true)
                .build());
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Pfizer").date("May 23, 2021").build()));
            tempPeople.getVaccines().add(vaccine);
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Pfizer").date("July 23, 2021").build()));
            tempPeople.getVaccines().add(vaccine);

        tempPeople = peopleRepository.save(People.builder()
                .name("Vishal")
                .surname("Wilkins")
                .age(21L)
                .hometown("Airport Street")
                .imgUrls("https://st.depositphotos.com/1269204/1219/i/450/depositphotos_12196477-stock-photo-smiling-men-isolated-on-the.jpg")
                .vaccinated(true)
                .build());
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("AstraZeneca").date("April 28, 2021").build()));
            tempPeople.getVaccines().add(vaccine);
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").date("July 31, 2021").build()));
            tempPeople.getVaccines().add(vaccine);


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
                .enabled(true)
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
