package ro.healtyrun.objectives.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.healtyrun.objectives.model.FormData;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FormDataRepository extends JpaRepository<FormData, UUID> {

    @Query("SELECT fd FROM FormData fd where fd.userId = :userId")
    List<FormData> findByUserId(UUID userId);
}
