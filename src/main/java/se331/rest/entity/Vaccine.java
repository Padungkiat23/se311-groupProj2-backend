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
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String date;
//    @ManyToMany
//    List<People> gotVaccinated;
}

