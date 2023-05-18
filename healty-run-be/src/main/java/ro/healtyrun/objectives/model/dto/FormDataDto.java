package ro.healtyrun.objectives.model.dto;

import lombok.Builder;
import lombok.Data;
import ro.healtyrun.objectives.model.QuestionsAnswers;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class FormDataDto {

    private UUID id;

    private UUID userId;

    private List<QuestionsAnswers> questionsAnswersList;
}
