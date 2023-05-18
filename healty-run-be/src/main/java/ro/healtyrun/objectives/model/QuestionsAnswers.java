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
@Table(name = "questions_answers")
public class QuestionsAnswers {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator
    @Column(name = "questions_answers_id")
    private UUID id;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;

}
