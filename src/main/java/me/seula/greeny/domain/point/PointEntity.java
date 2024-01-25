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

    /*
        포인트량
    */
    @Column(nullable = false)
    private int point;

    /*
        유저 외래키

        근데 이거 외래키 써야됨 ?
    */
    @ManyToOne
    @JoinColumn(nullable = false)
    private UserEntity user;

    /*
        업데이트 된 날짜

        이거 수정 필요
    */
    @CreatedDate
    private LocalDateTime addedAt;

    @Builder
    public PointEntity(int point, UserEntity user) {
        this.point = point;
        this.user = user;
        this.addedAt = LocalDateTime.now();
    }
}
