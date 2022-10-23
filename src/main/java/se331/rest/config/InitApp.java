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
        doc3 = doctorRepository.save(Doctor.builder().name("Dr.Atsuma Kawaii").build());

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

        tempPeople = peopleRepository.save(People.builder()
                .name("Bodhi")
                .surname("Buxton")
                .age(19L)
                .hometown("87 Tailwater Ave. Lawrence, MA 01841")
                .vaccinated(true)
                .build());

                tempPeople.getVaccines().add(vac1);
                tempPeople.setVac_date("February 9, 2021");
                tempPeople.getVaccines().add(vac2);
                tempPeople.setVac_date("June 11, 2021");

        tempPeople = peopleRepository.save(People.builder()
                .name("Hakim")
                .surname("Schwartz")
                .age(18L)
                .hometown("56 Temple Dr. Melrose, MA 02176")
                .vaccinated(true)
                .build());

        tempPeople.getVaccines().add(vac1);
        tempPeople.setVac_date("February 26, 2021");
        tempPeople.getVaccines().add(vac2);
        tempPeople.setVac_date("June 16, 2021");

        tempPeople = peopleRepository.save(People.builder()
                .name("Ezekiel")
                .surname("Sanchez")
                .age(25L)
                .hometown("316 Belmont Lane Longwood, FL 32779")
                .vaccinated(true)
                .build());

        tempPeople.getVaccines().add(vac1);
        tempPeople.setVac_date("July 1, 2021");
        tempPeople.getVaccines().add(vac2);
        tempPeople.setVac_date("October 5, 2021");

        tempPeople = peopleRepository.save(People.builder()
                .name("Dayna")
                .surname("John")
                .age(22L)
                .hometown("593 Purple Finch Drive Brooklyn, NY 11201")
                .vaccinated(true)
                .build());

        tempPeople.getVaccines().add(vac1);
        tempPeople.setVac_date("October 30, 2021");
        tempPeople.getVaccines().add(vac2);
        tempPeople.setVac_date("January 16, 2022");

        tempPeople = peopleRepository.save(People.builder()
                .name("Devonte")
                .surname("Corona")
                .age(30L)
                .hometown("7618 Ridge St. Abingdon, MD 21009")
                .vaccinated(true)
                .build());

        tempPeople.getVaccines().add(vac1);
        tempPeople.setVac_date("January 6, 2022");
        tempPeople.getVaccines().add(vac2);
        tempPeople.setVac_date("May 1, 2022");

        tempPeople = peopleRepository.save(People.builder()
                .name("Tatiana")
                .surname("Aksel")
                .age(28L)
                .hometown("723 North Carson Dr. Owensboro, KY 42301")
                .vaccinated(true)
                .build());

        tempPeople.getVaccines().add(vac1);
        tempPeople.setVac_date("January 16, 2022");

        tempPeople = peopleRepository.save(People.builder()
                .name("Evelyn")
                .surname("Horne")
                .age(32L)
                .hometown("8657 Prairie Drive Reynoldsburg, OH 43068")
                .vaccinated(true)
                .build());

        tempPeople.getVaccines().add(vac1);
        tempPeople.setVac_date("December 22, 2021");

        tempPeople = peopleRepository.save(People.builder()
                .name("Anisah")
                .surname("Wagner")
                .age(36L)
                .hometown("330 N. Monroe Lane Clarksburg, WV 26301")
                .vaccinated(true)
                .build());

        tempPeople.getVaccines().add(vac1);
        tempPeople.setVac_date("June 28, 2021");
        tempPeople.getVaccines().add(vac2);
        tempPeople.setVac_date("October 28, 2021");

        tempPeople = peopleRepository.save(People.builder()
                .name("Thompson")
                .surname("Merritt")
                .age(42L)
                .hometown("162 Chestnut Ave. Marquette, MI 49855")
                .vaccinated(true)
                .build());

        tempPeople.getVaccines().add(vac1);
        tempPeople.setVac_date("August 27, 2020");
        tempPeople.getVaccines().add(vac2);
        tempPeople.setVac_date("December 28, 2020");

        tempPeople = peopleRepository.save(People.builder()
                .name("Julian")
                .surname("Rollins")
                .age(39L)
                .hometown("8652 Hillcrest Dr. Brownsburg, IN 46112")
                .vaccinated(true)
                .build());

        tempPeople.getVaccines().add(vac1);
        tempPeople.setVac_date("February 26, 2021");
        tempPeople.getVaccines().add(vac2);
        tempPeople.setVac_date("April 26, 2021");

        tempPeople = peopleRepository.save(People.builder()
                .name("Caitlin")
                .surname("Schneider")
                .age(30L)
                .hometown("9259 West James Street Cantonment, FL 32533")
                .vaccinated(true)
                .build());

        tempPeople.getVaccines().add(vac1);
        tempPeople.setVac_date("March 22, 2020");

        tempPeople = peopleRepository.save(People.builder()
                .name("Eshal")
                .surname("Villa")
                .age(38L)
                .hometown("499 Henry Road Commack, NY 11725")
                .vaccinated(true)
                .build());

        tempPeople.getVaccines().add(vac1);
        tempPeople.setVac_date("June 29, 2021");
        tempPeople.getVaccines().add(vac2);
        tempPeople.setVac_date("May 12, 2022");

        tempPeople = peopleRepository.save(People.builder()
                .name("John-Paul")
                .surname("Villa")
                .age(36L)
                .hometown("499 Henry Road Commack, NY 11725")
                .vaccinated(true)
                .build());

        tempPeople.getVaccines().add(vac1);
        tempPeople.setVac_date("January 2, 2020");
        tempPeople.getVaccines().add(vac2);
        tempPeople.setVac_date("August 22, 2020");

        tempPeople = peopleRepository.save(People.builder()
                .name("Wong")
                .surname("Asiyah")
                .age(31L)
                .hometown("17 Birchpond St. Bethesda, MD 20814")
                .vaccinated(true)
                .build());

        tempPeople.getVaccines().add(vac1);
        tempPeople.setVac_date("April 10, 2021");
        tempPeople.getVaccines().add(vac2);
        tempPeople.setVac_date("December 30, 2021");
    }
        // Authority configuration
        // Doctor is an admin, Patient is a user, Neither are disableUser
        User user1, user2, user3;
    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
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
                .username("user")
                .password(encoder.encode("user"))
                .firstname("user")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user3 = User.builder()
                .username("disableUser")
                .password(encoder.encode("disableUser"))
                .firstname("disableUser")
                .lastname("disableUser")
                .email("disableUser@user.com")
                .enabled(false)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        authorityRepository.save(authUser);
        authorityRepository.save(authAdmin);
        user1.getAuthorities().add(authUser);
        user1.getAuthorities().add(authAdmin);
        user2.getAuthorities().add(authUser);
        user3.getAuthorities().add(authUser);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}
