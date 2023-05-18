package ro.healtyrun.objectives.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.healtyrun.objectives.model.FormData;

import java.util.UUID;

public interface ObjectiveRepository extends JpaRepository<FormData, UUID> {
}
