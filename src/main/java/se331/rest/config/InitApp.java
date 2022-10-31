package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.rest.entity.*;
import se331.rest.repository.*;
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
    @Autowired
    CommentRepository commentRepository;


    @Override
    @Transactional

    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        addUser();

        Admin ad = null;
        ad = adminRepository.save(Admin.builder()
                .name("Admin")
                .email("admin@admin.com")
                .image("https://th.bing.com/th/id/OIP.TnPDLd_LQS8FBzu_kGIUUwHaHa?pid=ImgDet&rs=1")
                .build());
        ad.setUser(admin);
        admin.setAdmin(ad);

        Doctor doc1,doc2;
        doc1 = doctorRepository.save(Doctor.builder()
                .name("Dr.Smith Henry")
                .email("Smith@doctor.com")
                .image("https://i.pinimg.com/736x/38/17/7d/38177db42101d8127effc62fca70c77e.jpg")
                .build());
        doc1.setUser(doctor);
        doctor.setDoctor(doc1);

        doc2 = doctorRepository.save(Doctor.builder()
                .name("Dr.Afar Zir")
                .email("Afar@doctor.com")
                .image("https://i.pinimg.com/originals/d0/01/01/d00101e76c5b63567dc7e22a970bfe08.jpg")
                .build());
        doc2.setUser(doctor2);
        doctor2.setDoctor(doc2);
        Comment comment = null;

        Vaccine vaccine = null;
        People tempPeople = null;
        //people no 1
        tempPeople = peopleRepository.save(People.builder()
                .name("Giorno")
                .surname("Giovanna")
                .age(17L)
                .hometown("Bandon")
                .imgUrls("https://i.pinimg.com/originals/aa/a4/9f/aaa49f0db95279ad4eeb8fe8117e95ed.png")
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

            comment = commentRepository.save(Comment.builder()
                .comment("I am a fighter")
                .build());
            tempPeople.getCommentList().add(comment);
            tempPeople.setUser(user1);
            user1.setPeople(tempPeople);

            // user no 2
        tempPeople = peopleRepository.save(People.builder()
                .name("Payrai")
                .surname("Najar")
                .age(23L)
                .hometown("7Saint Charles")
                .imgUrls("https://i.pinimg.com/originals/17/b9/f2/17b9f2d24c506dce5cf2147b4705f1b5.jpg")
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
        comment = commentRepository.save(Comment.builder()
                .comment("Beauty Skin")
                .build());
        tempPeople.getCommentList().add(comment);
        tempPeople.setUser(user2);
        user2.setPeople(tempPeople);

        // user no 3
        tempPeople = peopleRepository.save(People.builder()
                .name("Vasaz")
                .surname("Gizar")
                .age(24L)
                .hometown("Ionian river")
                .imgUrls("https://i.pinimg.com/originals/ba/47/ec/ba47ec3a39e5482722963dd423601077.jpg")
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
        comment = commentRepository.save(Comment.builder()
                .comment("Oh lar")
                .build());
        tempPeople.getCommentList().add(comment);
        tempPeople.setUser(user3);
        user3.setPeople(tempPeople);

        // user no 4
        tempPeople = peopleRepository.save(People.builder()
                .name("Zed")
                .surname("Shadow")
                .age(25L)
                .hometown("Bearer Iron")
                .imgUrls("https://i.pinimg.com/550x/bf/1d/89/bf1d89ead409006d160f303a03aba16a.jpg")
                .vaccinated(true)
                .build());
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Pfizer").date("February 7, 2021").build()));
            tempPeople.getVaccines().add(vaccine);
            vaccine = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").date("May 7, 2021").build()));
            tempPeople.getVaccines().add(vaccine);
        doc1.getOwnPeople().add(tempPeople);
        tempPeople.setDoctor(doc1);
        comment = commentRepository.save(Comment.builder()
                .comment("Oh ayeeeee")
                .build());
        tempPeople.getCommentList().add(comment);
        tempPeople.setUser(user4);
        user4.setPeople(tempPeople);

        //people no 5
        tempPeople = peopleRepository.save(People.builder()
                .name("Zafar")
                .surname("Matilda")
                .age(28L)
                .hometown("Forney")
                .imgUrls("https://i.pinimg.com/236x/7e/ac/5c/7eac5cfaff5d5eead71b43c3811465e8.jpg")
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
        comment = commentRepository.save(Comment.builder()
                .comment("Oh dazeee lar")
                .build());
        tempPeople.getCommentList().add(comment);
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
        admin = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("Admin")
                .lastname("isDabest")
                .email("admin@admin.com")
                .image("https://th.bing.com/th/id/OIP.TnPDLd_LQS8FBzu_kGIUUwHaHa?pid=ImgDet&rs=1")
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
                .image("https://i.pinimg.com/736x/38/17/7d/38177db42101d8127effc62fca70c77e.jpg")
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
                .image("https://i.pinimg.com/originals/d0/01/01/d00101e76c5b63567dc7e22a970bfe08.jpg")
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
                .image("https://i.pinimg.com/originals/e8/c4/88/e8c488b26106373c5e53ba18c455b00e.png")
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
                .image("https://i.ytimg.com/vi/mn_PqjntMcU/maxresdefault.jpg")
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
                .image("https://i.kym-cdn.com/entries/icons/original/000/018/743/maxresdefault.jpg")
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
                .image("https://i.pinimg.com/originals/58/6c/cb/586ccb38c0aa9e53fe37a8f6dec8ff9e.jpg")
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
                .image("https://i.pinimg.com/originals/13/73/ec/1373ec04a62741cf6b1b29d172528242.jpg")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        authorityRepository.save(authUser);
        authorityRepository.save(authDoctor);
        authorityRepository.save(authAdmin);
        admin.getAuthorities().add(authAdmin);
        doctor.getAuthorities().add(authDoctor);
        doctor2.getAuthorities().add(authDoctor);
        user1.getAuthorities().add(authUser);
        user2.getAuthorities().add(authUser);
        user3.getAuthorities().add(authUser);
        user4.getAuthorities().add(authUser);
        user5.getAuthorities().add(authUser);
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