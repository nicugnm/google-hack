package ro.healtyrun.objectives.payload.response;

import lombok.Builder;
import lombok.Data;
import ro.healtyrun.objectives.model.dto.ObjectiveDto;

import java.util.List;

@Data
@Builder
public class ObjectiveResponse {

    private List<ObjectiveDto> objectiveList;
}
