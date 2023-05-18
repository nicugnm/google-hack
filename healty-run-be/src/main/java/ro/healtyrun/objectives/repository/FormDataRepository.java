package ro.healtyrun.objectives.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.healtyrun.objectives.model.FormData;
import ro.healtyrun.objectives.model.QuestionsAnswers;

import java.util.UUID;

public interface FormDataRepository extends JpaRepository<FormData, UUID> {
}
