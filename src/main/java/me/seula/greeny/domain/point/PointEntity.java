package me.seula.greeny.domain.point;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import me.seula.greeny.domain.user.UserEntity;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class PointEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int point;

    @ManyToOne
    @JoinColumn(nullable = false)
    private UserEntity user;

    @CreatedDate
    private LocalDateTime addedAt;

    @Builder
    public PointEntity(int point, UserEntity user) {
        this.point = point;
        this.user = user;
    }
}
