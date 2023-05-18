package ro.healtyrun.objectives.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.healtyrun.objectives.model.QuestionsAnswers;

import java.util.UUID;

public interface QuestionsAnswersRepository extends JpaRepository<QuestionsAnswers, UUID> {
}
