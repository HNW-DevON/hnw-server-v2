package me.seula.greeny.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
        사용자명
    */
    private String username;

    /*
        비밀번호
    */
    private String password;

    /*
        이름
     */
    private String name;

    /*
        생년월일
    */
    private String birth;

    /*
        권한 정보 (임시)
    */
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
