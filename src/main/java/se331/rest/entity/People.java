package se331.rest.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
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

    @OneToMany
    @Builder.Default
    List<Doctor> doc_name = new ArrayList<>();
//    @ManyToOne
//    Vaccine vac_get;
    @OneToMany
    @Builder.Default
    List<Vaccine> vaccines = new ArrayList<>();
    // map in participant
//    @ManyToMany(mappedBy = "gotVaccinated")
    @ManyToMany
    List<Vaccine> participants;
    // people images
    @ElementCollection
    List<String> imageUrls;

}


