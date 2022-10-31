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
                .email("admin@admin.com")
                .image("https://visualpharm.com/assets/381/Admin-595b40b65ba036ed117d3b23.svg")
                .build());
        ad.setUser(admin);
        admin.setAdmin(ad);

        Doctor doc1,doc2;
        doc1 = doctorRepository.save(Doctor.builder()
                .name("Dr.Smith Henry")
                .email("Smith@doctor.com")
                .image("https://www.thonburibamrungmuang.com/images/upload/editor/source/Doctor/m-doctor-360x215-011.jpg")
                .build());
        doc1.setUser(doctor);
        doctor.setDoctor(doc1);

        doc2 = doctorRepository.save(Doctor.builder()
                .name("Dr.Afar Zir")
                .email("Afar@doctor.com")
                .image("https://www.thonburibamrungmuang.com/images/upload/editor/source/Doctor/m-doctor-360x215-011.jpg")
                .build());
        doc2.setUser(doctor2);
        doctor2.setDoctor(doc2);

        Vaccine vaccine = null;
        People tempPeople = null;
        //people no 1
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

            doc1.getOwnPeople().add(tempPeople);
            tempPeople.setDoctor(doc1);
        tempPeople.setUser(user1);
        user1.setPeople(tempPeople);

        //people no 2
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
        doc1.getOwnPeople().add(tempPeople);
        tempPeople.setDoctor(doc1);
        tempPeople.setUser(user2);
        user2.setPeople(tempPeople);

        //people no 3
        tempPeople = peopleRepository.save(People.builder()
                .name("Vasaz")
                .surname("Gizar")
                .age(24L)
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
        doc1.getOwnPeople().add(tempPeople);
        tempPeople.setDoctor(doc1);
        tempPeople.setUser(user3);
        user3.setPeople(tempPeople);

        //people no 4
        tempPeople = peopleRepository.save(People.builder()
                .name("Vance")
                .surname("Bijou")
                .age(26L)
                .hometown("Williamstown")
                .imgUrls("https://st.depositphotos.com/1269204/1219/i/450/depositphotos_12196477-stock-photo-smiling-men-isolated-on-the.jpg")
                .vaccinated(true)
                .build());
        vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("AstraZeneca").date("January 14, 2021").build()));
        tempPeople.getVaccines().add(vaccine);
        vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("AstraZeneca").date("March 14, 2021").build()));
        tempPeople.getVaccines().add(vaccine);
        doc2.getOwnPeople().add(tempPeople);
        tempPeople.setDoctor(doc2);
        tempPeople.setUser(user4);
        user4.setPeople(tempPeople);

        //people no 5
        tempPeople = peopleRepository.save(People.builder()
                .name("Zafar")
                .surname("Matilda")
                .age(28L)
                .hometown("Forney")
                .imgUrls("https://st.depositphotos.com/1269204/1219/i/450/depositphotos_12196477-stock-photo-smiling-men-isolated-on-the.jpg")
                .vaccinated(true)
                .build());
        vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("AstraZeneca").date("January 14, 2021").build()));
        tempPeople.getVaccines().add(vaccine);
        vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("AstraZeneca").date("March 14, 2021").build()));
        tempPeople.getVaccines().add(vaccine);
        doc2.getOwnPeople().add(tempPeople);
        tempPeople.setDoctor(doc2);
        tempPeople.setUser(user5);
        user5.setPeople(tempPeople);

    }
        // Authority configuration
        // Doctor is an admin, Patient is a user, Neither are disableUser

        User admin, doctor, doctor2, user1, user2, user3, user4, user5;
    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authDoctor = Authority.builder().name(AuthorityName.ROLE_DOCTOR).build();
        Authority authUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
        Authority authAdmin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        Authority authPeople = Authority.builder().name(AuthorityName.ROLE_PEOPLE).build();
        admin = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("Admin")
                .lastname("isDabest")
                .email("admin@admin.com")
                .image("https://visualpharm.com/assets/381/Admin-595b40b65ba036ed117d3b23.svg")
                .age("99")
                .hometown("Heaven")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        doctor = User.builder()
                .username("doctor")
                .password(encoder.encode("doctor"))
                .firstname("Dr.Smith")
                .lastname("Smith")
                .email("smith@doctor.com")
                .image("https://www.thonburibamrungmuang.com/images/upload/editor/source/Doctor/m-doctor-360x215-011.jpg")
                .age("1000")
                .hometown("Hospital")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        doctor2 = User.builder()
                .username("doctor2")
                .password(encoder.encode("doctor2"))
                .firstname("Dr.Afar")
                .lastname("Zir")
                .email("Afar@doctor.com")
                .age("1000")
                .hometown("Hospital")
                .image("https://www.thonburibamrungmuang.com/images/upload/editor/source/Doctor/m-doctor-360x215-011.jpg")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user1 = User.builder()
                .username("user1")
                .password(encoder.encode("user1"))
                .firstname("Rebekka")
                .lastname("Léo")
                .email("user3@user.com")
                .age("23")
                .hometown("Lynchburg")
                .image("https://images.unsplash.com/photo-1570295999919-56ceb5ecca61?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8dXNlcnxlbnwwfHwwfHw%3D&w=1000&q=80")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user2 = User.builder()
                .username("user2")
                .password(encoder.encode("user2"))
                .firstname("Sofya")
                .lastname("Gisila")
                .email("user4@user.com")
                .age("18")
                .hometown("Lebanon")
                .image("https://images.unsplash.com/photo-1570295999919-56ceb5ecca61?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8dXNlcnxlbnwwfHwwfHw%3D&w=1000&q=80")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user3 = User.builder()
                .username("user3")
                .password(encoder.encode("user3"))
                .firstname("Anil")
                .lastname("Paz")
                .email("user3@user.com")
                .age("20")
                .hometown("Fairmont")
                .image("https://images.unsplash.com/photo-1570295999919-56ceb5ecca61?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8dXNlcnxlbnwwfHwwfHw%3D&w=1000&q=80")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user4 = User.builder()
                .username("user4")
                .password(encoder.encode("user4"))
                .firstname("Lowe")
                .lastname("Randi")
                .email("user4@user.com")
                .age("25")
                .hometown("Collegeville")
                .image("https://images.unsplash.com/photo-1570295999919-56ceb5ecca61?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8dXNlcnxlbnwwfHwwfHw%3D&w=1000&q=80")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user5 = User.builder()
                .username("user5")
                .password(encoder.encode("user5"))
                .firstname("Platon")
                .lastname("Catello")
                .email("user5@user.com")
                .age("22")
                .hometown("Woburn")
                .image("https://images.unsplash.com/photo-1570295999919-56ceb5ecca61?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8dXNlcnxlbnwwfHwwfHw%3D&w=1000&q=80")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        authorityRepository.save(authUser);
        authorityRepository.save(authDoctor);
        authorityRepository.save(authAdmin);
        admin.getAuthorities().add(authAdmin);
        doctor.getAuthorities().add(authDoctor);
        doctor2.getAuthorities().add(authDoctor);
        user1.getAuthorities().add(authPeople);
        user2.getAuthorities().add(authPeople);
        user3.getAuthorities().add(authPeople);
        user4.getAuthorities().add(authPeople);
        user5.getAuthorities().add(authPeople);
        userRepository.save(admin);
        userRepository.save(doctor);
        userRepository.save(doctor2);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
    }
}