package ro.healtyrun.objectives.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.healtyrun.objectives.exceptions.UserObjectivesNotFound;
import ro.healtyrun.objectives.mapper.ObjectiveMapper;
import ro.healtyrun.objectives.mapper.QuestionsAnswersMapper;
import ro.healtyrun.objectives.model.FormData;
import ro.healtyrun.objectives.model.Objective;
import ro.healtyrun.objectives.model.QuestionsAnswers;
import ro.healtyrun.objectives.model.dto.FormDataDto;
import ro.healtyrun.objectives.model.dto.ObjectiveDto;
import ro.healtyrun.objectives.payload.request.FormDataRequest;
import ro.healtyrun.objectives.payload.response.MessageResponse;
import ro.healtyrun.objectives.payload.response.ObjectiveResponse;
import ro.healtyrun.objectives.repository.ObjectiveRepository;
import ro.healtyrun.objectives.repository.QuestionsAnswersRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ObjectiveService {

    private final ObjectiveRepository objectiveRepository;
    private final GPTService gptService;
    private final FormDataService formDataService;
    private final QuestionsAnswersRepository questionsAnswersRepository;

    @Transactional
    public ResponseEntity<MessageResponse> saveFormData(FormDataRequest formDataRequest) {
        List<QuestionsAnswers> questionsAnswersList = QuestionsAnswersMapper.INSTANCE.toEntityList(formDataRequest.getQuestionsAnswersList());
        questionsAnswersRepository.saveAllAndFlush(questionsAnswersList);

        questionsAnswersList.forEach(questionAnswer -> {
            FormData formData = FormData.builder()
                    .userId(formDataRequest.getUserId())
                    .questionsAnswersId(questionAnswer.getId())
                    .build();

            formDataService.saveFormData(formData);
        });

        return ResponseEntity.ok(gptService.getGPTObjective(formDataRequest.getUserId()));
    }

    public ResponseEntity<List<ObjectiveResponse>> getObjectives(UUID uuid) {
        List<ObjectiveDto> objectiveDtoList = getUserObjectives(uuid).stream()
                .map(ObjectiveMapper.INSTANCE::toResponse)
                .toList();

        if (objectiveDtoList.isEmpty()) {
            throw new UserObjectivesNotFound("User does not have any objectives!");
        }

        return ResponseEntity.ok(ObjectiveMapper.INSTANCE.dtoListToResponseList(objectiveDtoList));
    }

    public List<Objective> getUserObjectives(UUID uuid) {
        return objectiveRepository.findAllByUserId(uuid);
    }
}
