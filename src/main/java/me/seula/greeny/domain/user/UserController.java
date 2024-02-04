package me.seula.greeny.domain.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file")MultipartFile file) {
        try {
            userService.uploadImage(file);
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "될 거 같음? ㅋㅋ";
        }
    }

    @GetMapping("/image")
    public Resource getImage() {
        return userService.getImage();
    }

    @PostMapping("/edit")
    public void editUser(EditDTO editDTO) {
        userService.editUser(editDTO);
    }
}
