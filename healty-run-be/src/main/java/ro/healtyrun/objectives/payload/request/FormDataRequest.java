package ro.healtyrun.objectives.payload.request;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class FormDataRequest {

    private UUID userId;

    private List<QuestionsAnswersDto> questionsAnswersList;
}
