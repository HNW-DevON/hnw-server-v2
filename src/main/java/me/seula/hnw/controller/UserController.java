package me.seula.hnw.controller;

import lombok.RequiredArgsConstructor;
import me.seula.hnw.dto.RegisterDTO;
import me.seula.hnw.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public String register(RegisterDTO registerDTO) {
        userService.register(registerDTO);
        return "ok";
    }
}
