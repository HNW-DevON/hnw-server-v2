package me.seula.greeny.domain.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterDTO {

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

}
