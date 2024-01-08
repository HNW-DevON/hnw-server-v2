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

    private String username;

    private String password;

    private String name;

    private String birth;

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
