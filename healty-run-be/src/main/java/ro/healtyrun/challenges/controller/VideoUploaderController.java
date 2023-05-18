package ro.healtyrun.challenges.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.healtyrun.challenges.payload.response.ChallengeResponse;
import ro.healtyrun.challenges.service.VideoUploaderService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/uploader")
@CrossOrigin(origins = "http://localhost:3000")
public class VideoUploaderController {

    private final VideoUploaderService videoUploaderService;

    @PostMapping
    public ResponseEntity<String> uploadVideo(@RequestParam("file") MultipartFile file,
                                              @RequestParam("userId") UUID userId,
                                              @RequestParam("challengerId") UUID challengerId,
                                              @RequestParam("description") String description) {
        return videoUploaderService.uploadVideo(file, userId, challengerId, description);
    }

    @GetMapping("/challenges")
    public List<ChallengeResponse> getChallengesByUserId(UUID userId) {
        return videoUploaderService.getChallengesByUserId(userId);
    }
}
