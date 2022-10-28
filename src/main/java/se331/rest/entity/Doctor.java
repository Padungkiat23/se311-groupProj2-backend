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

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;

    @ManyToOne
    Comment doc_comment;

    @OneToMany(mappedBy = "doctor")
    @Builder.Default
    List<People> ownPeople = new ArrayList<>();

    @OneToOne
    User user;
}

