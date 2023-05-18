package ro.healtyrun.challenges.payload.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ChallengeResponse {

    private String description;

    private LocalDateTime expirationDate;

    private String videoName;

    private String filePath;
}