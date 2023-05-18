package ro.healtyrun.friends.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.healtyrun.friends.model.Friends;

import java.util.List;
import java.util.UUID;

public interface FriendsRepository extends JpaRepository<Friends, UUID> {

    @Query("SELECT f FROM Friends f WHERE f.userId = :userId")
    List<Friends> findAllByUserId(UUID userId);

    @Query("DELETE FROM Friends f WHERE f.userId = :userId AND f.friendId = :friendId")
    List<Friends> deleteFriendById(UUID userId, UUID friendId);
}
