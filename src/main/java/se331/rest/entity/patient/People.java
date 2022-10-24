package se331.rest.entity.patient;


import lombok.*;
import se331.rest.entity.comment.Comment;
import se331.rest.entity.vaccine.Vaccine;
import se331.rest.entity.doctor.Doctor;
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

    @OneToOne(mappedBy = "patient")
    User user;

    @OneToMany
    @Builder.Default
    List<Vaccine> vaccines = new ArrayList<>();

    @OneToMany(mappedBy = "comment_to", cascade = CascadeType.ALL)
    List<Comment> doc_comment = new ArrayList<>();

    @ElementCollection
    List<String> imageUrls;

}


