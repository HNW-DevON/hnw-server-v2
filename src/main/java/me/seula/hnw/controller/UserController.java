package me.seula.hnw.controller;

import me.seula.hnw.dto.RegisterDTO;
import me.seula.hnw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(RegisterDTO registerDTO) {
        userService.register(registerDTO);
        return "ok";
    }
}
