package se331.rest.entity.comment;

import lombok.*;
import se331.rest.entity.doctor.Doctor;
import se331.rest.entity.patient.People;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String content;

    @ManyToOne
    Doctor comment_by;

    @ManyToOne
    People comment_to;
}
