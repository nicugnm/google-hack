package ro.healtyrun.objectives.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "forms_data")
public class FormData {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator
    @Column(name = "form_data_id")
    private UUID id;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "questions_answers_id")
    private UUID questionsAnswersId;
}
