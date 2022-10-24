package se331.rest.entity.doctor;

import lombok.*;
import se331.rest.entity.comment.Comment;
import se331.rest.entity.patient.People;
import se331.rest.security.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;

    @OneToMany(mappedBy = "comment_by", cascade = CascadeType.ALL)
    List<Comment> comment;

//    @Builder.Default
//    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
//    List<People> patients = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)// map with doctor in People.java
    List<People> ownPeoples = new ArrayList<>();

    @OneToOne(mappedBy = "doctor", cascade = CascadeType.ALL)
    User user;
}

