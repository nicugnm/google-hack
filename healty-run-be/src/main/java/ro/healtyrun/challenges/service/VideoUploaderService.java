package ro.healtyrun.challenges.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ro.healtyrun.challenges.model.Challenge;
import ro.healtyrun.challenges.payload.response.ChallengeResponse;
import ro.healtyrun.challenges.repository.ChallengeRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VideoUploaderService {

    private final ChallengeRepository challengeRepository;

    @Transactional
    public ResponseEntity<String> uploadVideo(MultipartFile file,
                                              UUID userId,
                                              UUID challengerId,
                                              String description) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("/saves/" + userId.toString() + "/video/" + file.getOriginalFilename());
            Files.write(path, bytes);

            Challenge challenge = Challenge.builder()
                    .userId(userId)
                    .filePath(path.toString())
                    .challengerId(challengerId)
                    .videoName(file.getOriginalFilename())
                    .description(description)
                    .build();

            challengeRepository.saveAndFlush(challenge);

            return new ResponseEntity<>("Video file uploaded and saved successfully: " + file.getOriginalFilename(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Video upload failed: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public List<ChallengeResponse> getChallengesByUserId(UUID userId) {
        List<Challenge> challengeList = challengeRepository.findChallengeByUserId(userId);

        return challengeList.stream()
                .map(challenge -> ChallengeResponse.builder()
                        .filePath(challenge.getFilePath())
                        .videoName(challenge.getVideoName())
                        .expirationDate(challenge.getExpirationDate())
                        .description(challenge.getDescription())
                        .build())
                .toList();
    }
}
