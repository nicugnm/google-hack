package ro.healtyrun.objectives.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.healtyrun.objectives.payload.request.FormDataRequest;
import ro.healtyrun.objectives.payload.response.MessageResponse;
import ro.healtyrun.objectives.service.ObjectiveService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/objectives")
public class ObjectivesController {

    private final ObjectiveService objectiveService;

    @PostMapping
    public ResponseEntity<MessageResponse> saveFormData(@RequestBody FormDataRequest formDataRequest) {
        return objectiveService.saveFormData(formDataRequest);
    }
}
