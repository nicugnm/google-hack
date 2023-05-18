package ro.healtyrun.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.healtyrun.login.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    @Query("SELECT u from User u where u.id = :uuid")
    Optional<User> findById(String uuid);

    @Query("SELECT u from User u WHERE u.email = :username")
    Optional<User> findByUsername(String username);
}
