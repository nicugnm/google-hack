package ro.healtyrun.objectives.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.healtyrun.objectives.model.Objective;

import java.util.List;
import java.util.UUID;

public interface ObjectiveRepository extends JpaRepository<Objective, UUID> {

    @Query("SELECT o FROM Objective o where o.userId = :userId")
    List<Objective> findAllByUserId(UUID userId);

}
