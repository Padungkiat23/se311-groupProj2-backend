package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.rest.entity.Admin;
import se331.rest.entity.Doctor;
import se331.rest.entity.People;
import se331.rest.entity.Vaccine;
import se331.rest.repository.AdminRepository;
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
    @Autowired
    AdminRepository adminRepository;




    @Override
    @Transactional

    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        addUser();

        Admin ad = null;
        ad = adminRepository.save(Admin.builder()
                .name("Admin")
                .build());
        ad.setUser(user1);
        user1.setAdmin(ad);

        Doctor doc = null;
        doc = doctorRepository.save(Doctor.builder()
                .name("Dr.Smith Henry")
                .build());
        doc.setUser(user2);
        user2.setDoctor(doc);

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
            tempPeople.setUser(user3);
                user3.setPeople(tempPeople);

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
        tempPeople.setUser(user4);
        user4.setPeople(tempPeople);

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
        tempPeople.setUser(user5);
        user5.setPeople(tempPeople);

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
        tempPeople.setUser(user6);
        user6.setPeople(tempPeople);

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
        tempPeople.setUser(user7);
        user7.setPeople(tempPeople);

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
        tempPeople.setUser(user8);
        user8.setPeople(tempPeople);

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
        tempPeople.setUser(user9);
        user9.setPeople(tempPeople);

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
        tempPeople.setUser(user10);
        user10.setPeople(tempPeople);

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
            tempPeople.setUser(user11);
            user11.setPeople(tempPeople);

    }
        // Authority configuration
        // Doctor is an admin, Patient is a user, Neither are disableUser

        User user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11;
    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authDoctor = Authority.builder().name(AuthorityName.ROLE_DOCTOR).build();
        Authority authPatient = Authority.builder().name(AuthorityName.ROLE_PATIENT).build();
        Authority authAdmin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user2 = User.builder()
                .username("doctor")
                .password(encoder.encode("doctor"))
                .firstname("doctor")
                .lastname("doctor")
                .email("doctor@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user3 = User.builder()
                .username("user3")
                .password(encoder.encode("user3"))
                .firstname("")
                .lastname("")
                .email("user3@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user4 = User.builder()
                .username("user4")
                .password(encoder.encode("user4"))
                .firstname("")
                .lastname("")
                .email("user4@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user5 = User.builder()
                .username("user5")
                .password(encoder.encode("user5"))
                .firstname("")
                .lastname("")
                .email("user5@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user6 = User.builder()
                .username("user6")
                .password(encoder.encode("user6"))
                .firstname("")
                .lastname("")
                .email("user6@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user7 = User.builder()
                .username("user7")
                .password(encoder.encode("user7"))
                .firstname("")
                .lastname("")
                .email("user7@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user8 = User.builder()
                .username("user8")
                .password(encoder.encode("user8"))
                .firstname("")
                .lastname("")
                .email("user8@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user9 = User.builder()
                .username("user9")
                .password(encoder.encode("user9"))
                .firstname("")
                .lastname("")
                .email("user9@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user10 = User.builder()
                .username("user10")
                .password(encoder.encode("user10"))
                .firstname("")
                .lastname("")
                .email("user10@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user11 = User.builder()
                .username("user11")
                .password(encoder.encode("user11"))
                .firstname("")
                .lastname("")
                .email("user11@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        authorityRepository.save(authPatient);
        authorityRepository.save(authDoctor);
        authorityRepository.save(authAdmin);
        user1.getAuthorities().add(authAdmin); // user1 is admin
        user2.getAuthorities().add(authDoctor); // user2 is doctor
        user3.getAuthorities().add(authPatient); //user3 is patient
        user4.getAuthorities().add(authPatient);
        user5.getAuthorities().add(authPatient);
        user6.getAuthorities().add(authPatient);
        user7.getAuthorities().add(authPatient);
        user8.getAuthorities().add(authPatient);
        user9.getAuthorities().add(authPatient);
        user10.getAuthorities().add(authPatient);
        user11.getAuthorities().add(authPatient);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        userRepository.save(user7);
        userRepository.save(user8);
        userRepository.save(user9);
        userRepository.save(user10);
        userRepository.save(user11);
    }
}
