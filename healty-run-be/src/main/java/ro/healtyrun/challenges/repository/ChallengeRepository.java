package ro.healtyrun.challenges.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.healtyrun.challenges.model.Challenge;
import ro.healtyrun.login.model.User;

import java.util.List;
import java.util.UUID;

public interface ChallengeRepository extends JpaRepository<Challenge, UUID> {

    @Query("SELECT c FROM Challenge c WHERE c.userId = :userId")
    List<Challenge> findChallengeByUserId(UUID userId);
}
