package ro.healtyrun.objectives.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import ro.healtyrun.objectives.model.FormData;
import ro.healtyrun.objectives.model.Objective;
import ro.healtyrun.objectives.model.dto.ObjectiveDto;
import ro.healtyrun.objectives.payload.request.FormDataRequest;
import ro.healtyrun.objectives.payload.response.ObjectiveResponse;
import ro.healtyrun.objectives.repository.ObjectiveRepository;

import java.util.List;

@Mapper
public interface ObjectiveMapper {

    ObjectiveMapper INSTANCE = Mappers.getMapper(ObjectiveMapper.class);

    ObjectiveDto toResponse(Objective objective);

    List<ObjectiveResponse> dtoListToResponseList(List<ObjectiveDto> objectiveDtoList);
}

