package me.seula.greeny.domain.pedia.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class PediaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
        바코드 번호
    */
    @Column(nullable = false)
    private String productId;

    /*
        인식한 유저 ID
    */
    // 외래키 쓸 이유 X
    @Column(nullable = false)
    private String username;

    /*
        도감에 추가된 시간
    */
    @CreatedDate
    private LocalDateTime addedAt;

    @Builder
    public PediaEntity (String productId, String username) {
        this.productId = productId;
        this.username = username;
        this.addedAt = LocalDateTime.now();
    }

}
