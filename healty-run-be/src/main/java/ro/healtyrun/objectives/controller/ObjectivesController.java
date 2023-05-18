package ro.healtyrun.objectives.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.healtyrun.objectives.payload.request.FormDataRequest;
import ro.healtyrun.objectives.payload.response.MessageResponse;
import ro.healtyrun.objectives.payload.response.ObjectiveResponse;
import ro.healtyrun.objectives.service.ObjectiveService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/objectives")
public class ObjectivesController {

    private final ObjectiveService objectiveService;

    @PostMapping
    public ResponseEntity<MessageResponse> saveFormData(@RequestBody FormDataRequest formDataRequest) {
        return objectiveService.saveFormData(formDataRequest);
    }

    @GetMapping
    public ResponseEntity<List<ObjectiveResponse>> getObjectives(@RequestBody UUID uuid) {
        return objectiveService.getObjectives(uuid);
    }
}
