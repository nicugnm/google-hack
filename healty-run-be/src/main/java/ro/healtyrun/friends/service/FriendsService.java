package ro.healtyrun.friends.service;

import lombok.RequiredArgsConstructor;
import org.eclipse.jetty.client.api.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ro.healtyrun.friends.mapper.FriendsMapper;
import ro.healtyrun.friends.model.Friends;
import ro.healtyrun.friends.model.dto.FriendsDto;
import ro.healtyrun.friends.repository.FriendsRepository;
import ro.healtyrun.login.model.User;
import ro.healtyrun.login.repository.UserRepository;
import ro.healtyrun.objectives.payload.response.MessageResponse;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FriendsService {

    private final FriendsRepository friendsRepository;
    private final UserRepository userRepository;

    public ResponseEntity<MessageResponse> addFriend(UserDetails userDetails, UUID friendId) {
        User user = userRepository.findByEmail(userDetails.getUsername()).get();
        Friends friends = Friends.builder()
                .userId(user.getId())
                .friendId(friendId)
                .build();

        friendsRepository.saveAndFlush(friends);

        return ResponseEntity.ok(MessageResponse.builder().build());
    }

    public ResponseEntity<List<FriendsDto>> getFriendsUserId(UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername()).get();
        List<FriendsDto> friends = FriendsMapper.INSTANCE.toDtoList(friendsRepository.findAllByUserId(user.getId()));

        return ResponseEntity.ok(friends);
    }

    public ResponseEntity<MessageResponse> deleteFriendById(UserDetails userDetails, UUID friendId) {
        User user = userRepository.findByEmail(userDetails.getUsername()).get();
        friendsRepository.deleteFriendById(user.getId(), friendId);

        return ResponseEntity.ok(MessageResponse.builder().build());
    }
}
