package me.seula.greeny.domain;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
        사용자명
    */
    @Column(nullable = false)
    private String username;

    /*
        비밀번호
    */
    @Column(nullable = false)
    private String password;

    /*
        이름
    */
    @Column(nullable = false)
    private String name;

    /*
        생년월일
    */
    @Column(nullable = false)
    private String birth;

    /*
        권한 정보 (임시)
    */
    @Column(nullable = false)
    private String role;

    @Builder
    public UserEntity(String username, String password, String name, String birth, String role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.role = role;
    }
}
