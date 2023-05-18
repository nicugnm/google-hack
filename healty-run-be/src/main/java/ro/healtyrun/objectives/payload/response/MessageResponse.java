package ro.healtyrun.objectives.payload.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class MessageResponse {

    @Builder.Default
    private String message = "Succes!";
}
