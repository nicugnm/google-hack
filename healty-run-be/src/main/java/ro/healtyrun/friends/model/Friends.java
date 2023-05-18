package ro.healtyrun.friends.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "friends")
public class Friends {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator
    @Column(name = "table_id")
    private UUID id;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "friend_id")
    private UUID friendId;
}