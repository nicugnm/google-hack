package ro.healtyrun.objectives.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.healtyrun.objectives.mapper.FormDataMapper;
import ro.healtyrun.objectives.payload.request.FormDataRequest;
import ro.healtyrun.objectives.payload.response.MessageResponse;
import ro.healtyrun.objectives.repository.FormDataRepository;

@Service
@RequiredArgsConstructor
public class ObjectiveService {

    private final FormDataRepository formDataRepository;

    public ResponseEntity<MessageResponse> saveFormData(FormDataRequest formDataRequest) {
        formDataRepository.save(FormDataMapper.INSTANCE.toEntity(formDataRequest));

        return ResponseEntity.ok(MessageResponse.builder().build());
    }
}
