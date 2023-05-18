package ro.healtyrun.friends.payload.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class FriendsResponse {

    private UUID friendId;

    private String username;
}
