package se331.rest.entity;


import lombok.*;
import se331.rest.security.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String surname;
    Long age;
    String hometown;
    String vac_date;
    Boolean vaccinated;

    @ManyToOne
    Doctor doctor;

    @OneToMany
    @Builder.Default
    List<Vaccine> vaccines = new ArrayList<>();
    // map in participant
//    @ManyToMany(mappedBy = "gotVaccinated")
//    List<Vaccine> participants;
    // people images
    @ElementCollection
    List<String> imageUrls;

    @OneToOne(mappedBy = "people")
    User user;

}


