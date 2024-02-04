package me.seula.greeny.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public String register(RegisterDTO registerDTO) {
        userService.register(registerDTO);
        return "ok";
    }

    @GetMapping("/tier")
    public ExpDTO getUserTier() {
        return userService.getUserTier();
    }
}
