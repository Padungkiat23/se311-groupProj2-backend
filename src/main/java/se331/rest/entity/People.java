package se331.rest.entity;


import lombok.*;

import javax.persistence.*;
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

    Boolean vaccinated;
    // one person can have many doctor
    @ManyToOne
    Doctor doctor;
    // entity vaccine
    @ManyToMany(mappedBy = "peopleVaccinated")
    List<Vaccine> vaccines;
    // people images
    @ElementCollection
    List<String> imageUrls;

}


