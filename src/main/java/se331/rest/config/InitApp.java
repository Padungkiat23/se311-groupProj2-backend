package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.rest.entity.People;
import se331.rest.entity.Vaccine;
import se331.rest.repository.PeopleRepository;
import se331.rest.repository.VaccinatedRepository;
import se331.rest.security.repository.AuthorityRepository;
import se331.rest.security.repository.UserRepository;
import javax.transaction.Transactional;
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
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        // Vaccine configuration
        Vaccine vac1, vac2, vac3, vac4;
        vac1 = vaccinatedRepository.save((Vaccine.builder()
                .name("Pfizer").build()));
        vac2 = vaccinatedRepository.save((Vaccine.builder()
                .name("Moderna").build()));
        vac3 = vaccinatedRepository.save((Vaccine.builder()
                .name("Sputnik V").build()));
        vac4 = vaccinatedRepository.save((Vaccine.builder()
                .name("AstraZeneca").build()));

        People tempPeople = null;
        tempPeople = peopleRepository.save(People.builder()
                .name("Vishal")
                .surname("Wilkins")
                .age(21L)
                .hometown("7263 Airport Street Saint Charles, IL 60174")
                .vaccinated(true)
                .build());
                tempPeople.getVaccines().add(vac1);
                tempPeople.setVac_date("January 22, 2021");
                tempPeople.getVaccines().add(vac2);
                tempPeople.setVac_date("March 22, 2021");
    }

//    User user1,user2,user3;
//    private  void addUser(){
//
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        Authority authUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
//        Authority authAdmin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
//        user1 = User.builder()
//                .username("admin")
//                .password(encoder.encode("admin"))
//                .firstname("admin")
//                .lastname("admin")
//                .email("admin@admin.com")
//                .enabled(true)
//                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
//                .build();
//
//        user2 = User.builder()
//                .username("user")
//                .password(encoder.encode("user"))
//                .firstname("user")
//                .lastname("user")
//                .email("enabled@user.com")
//                .enabled(true)
//                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01)
//                        .atStartOfDay(ZoneId.systemDefault()).toInstant()))
//                .build();
//        user3 = User.builder()
//                .username("disableUser")
//                .password(encoder.encode("disableUser"))
//                .firstname("disableUser")
//                .lastname("disableUser")
//                .email("disableUser@user.com")
//                .enabled(false)
//                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01)
//                        .atStartOfDay(ZoneId.systemDefault()).toInstant()))
//                .build();
//        authorityRepository.save(authUser);
//        authorityRepository.save(authAdmin);
//        user1.getAuthorities().add(authUser);
//        user1.getAuthorities().add(authAdmin);
//        user2.getAuthorities().add(authUser);
//        user3.getAuthorities().add(authUser);
//        userRepository.save(user1);
//        userRepository.save(user2);
//        userRepository.save(user3);
//    }
}
