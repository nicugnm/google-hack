package ro.healtyrun.friends.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ro.healtyrun.friends.model.dto.FriendsDto;
import ro.healtyrun.friends.service.FriendsService;
import ro.healtyrun.objectives.payload.response.MessageResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/friends")
public class FriendsController {

    private final FriendsService friendsService;

    @PostMapping
    public ResponseEntity<MessageResponse> addFriend(@AuthenticationPrincipal UserDetails user, @RequestParam("friendId") UUID friendId) {
        return friendsService.addFriend(user, friendId);
    }

    @GetMapping
    public ResponseEntity<List<FriendsDto>> getFriendsUserId(@AuthenticationPrincipal UserDetails user) {
        return friendsService.getFriendsUserId(user);
    }

    @DeleteMapping
    public ResponseEntity<MessageResponse> deleteFriendById(@AuthenticationPrincipal UserDetails user, @RequestParam("friendiD") UUID friendId) {
        return friendsService.deleteFriendById(user, friendId);
    }
}
