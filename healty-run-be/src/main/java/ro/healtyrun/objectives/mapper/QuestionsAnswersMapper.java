package ro.healtyrun.objectives.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ro.healtyrun.objectives.model.QuestionsAnswers;
import ro.healtyrun.objectives.payload.request.QuestionsAnswersDto;

import java.util.List;

@Mapper
public interface QuestionsAnswersMapper {

    QuestionsAnswersMapper INSTANCE = Mappers.getMapper(QuestionsAnswersMapper.class);

    QuestionsAnswers toEntity(QuestionsAnswersDto questionsAnswersDto);

    List<QuestionsAnswers> toEntityList(List<QuestionsAnswersDto> questionsAnswersDtoList);
}
