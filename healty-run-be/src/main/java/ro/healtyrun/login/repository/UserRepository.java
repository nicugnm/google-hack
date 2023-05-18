package ro.healtyrun.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.healtyrun.login.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);
}
