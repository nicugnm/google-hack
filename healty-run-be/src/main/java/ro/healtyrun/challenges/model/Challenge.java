package ro.healtyrun.challenges.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "challenges")
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator
    @Column(name = "challenge_id")
    private UUID id;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "challenger_id")
    private UUID challengerId;

    @Column(name = "description")
    private String description;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "video_name")
    private String videoName;

    @Column(name = "file_path")
    private String filePath;
}
