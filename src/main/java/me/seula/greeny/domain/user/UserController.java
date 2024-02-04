package me.seula.greeny.domain.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "유저", description = "유저 관련 API 모음")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원가입", description = "유저를 회원가입합니다")
    @PostMapping("/register")
    public String register(RegisterDTO registerDTO) {
        userService.register(registerDTO);
        return "ok";
    }

    @Operation(summary = "유저 티어 조회", description = "유저 티어와 잔여 EXP를 조회합니다")
    @GetMapping("/tier")
    public ExpDTO getUserTier() {
        return userService.getUserTier();
    }
}
