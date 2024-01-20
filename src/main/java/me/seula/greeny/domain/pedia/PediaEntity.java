package me.seula.greeny.domain.pedia;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Builder
    public PediaEntity (String productId, String username) {
        this.productId = productId;
        this.username = username;
    }

}
