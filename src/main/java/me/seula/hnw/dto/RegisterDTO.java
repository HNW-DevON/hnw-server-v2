package me.seula.hnw.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterDTO {
    private String username;

    private String password;

    private String name;

    private String birth;
}
