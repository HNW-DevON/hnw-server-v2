package me.seula.hnw.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // 사용자명
    private String username;

    // 패스워드
    private String password;

    // 이름
    private String name;

    // 생년월일
    private String birth;

    /*
        유저의 권한을 나타냄
    */
    private String role;
}
