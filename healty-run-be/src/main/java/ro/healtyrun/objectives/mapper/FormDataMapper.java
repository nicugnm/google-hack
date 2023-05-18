package ro.healtyrun.objectives.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ro.healtyrun.objectives.model.FormData;
import ro.healtyrun.objectives.payload.request.FormDataRequest;

@Mapper
public interface FormDataMapper {

    FormDataMapper INSTANCE = Mappers.getMapper(FormDataMapper.class);

    FormData toEntity(FormDataRequest formDataRequest);
}
