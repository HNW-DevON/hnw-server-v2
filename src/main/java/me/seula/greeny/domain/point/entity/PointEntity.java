package me.seula.greeny.domain.point.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.seula.greeny.domain.user.entity.UserEntity;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class PointEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
        포인트량
    */
    @Column(nullable = false)
    private int point;

    /*
        유저 외래키
    */
    @ManyToOne
    @JoinColumn(nullable = false)
    private UserEntity user;

    /*
        포인트 받은 제품 ID
    */
    private String productId;

    /*
        업데이트 된 날짜
    */
    @CreatedDate
    private LocalDate addedAt;

    @Builder
    public PointEntity(int point, String productId, UserEntity user) {
        this.point = point;
        this.user = user;
        this.productId = productId;
        this.addedAt = LocalDateTime.now().toLocalDate();
    }
}
