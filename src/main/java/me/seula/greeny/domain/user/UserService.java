package me.seula.greeny.domain.user;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void register(RegisterDTO registerDTO) {
        String username = registerDTO.getUsername();

        if (userRepository.findByUsername(username).isPresent()) {
            return;
        }


        userRepository.save(
                UserEntity.builder()
                        .username(registerDTO.getUsername())
                        .password(bCryptPasswordEncoder.encode(registerDTO.getPassword()))
                        .name(registerDTO.getName())
                        .birth(registerDTO.getBirth())
                        .totalExp(0)
                        .hasPoint(0)
                        .role("ROLE_USER")
                        .build()
        );
    }

    public void uploadImage(MultipartFile file) throws IOException {
        String uploadPath = "/profileImages/";

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        String filePath = uploadPath + fileName;

        File dest = new File(filePath);
        file.transferTo(dest);
    }

    public void addExp() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User Entity Not Found"));

        user.setTotalExp(user.getTotalExp() + 25);
    }

    public ExpDTO getUserTier() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User Entity Not Found"));

        return new ExpDTO(user.getTier(), user.getTotalExp() % 100);
    }

    public void updateUserTier() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User Entity Not Found"));

        int tier = user.getTotalExp() / 100;

        switch(tier) {
            case 1:
                user.setTier("씨앗 3");
                break;
            case 2:
                user.setTier("씨앗 2");
                break;
            case 3:
                user.setTier("씨앗 1");

            case 4:
                user.setTier("새싹 3");
                break;
            case 5:
                user.setTier("새싹 2");
                break;
            case 6:
                user.setTier("새싹 1");
                break;

            case 7:
                user.setTier("나무 3");
                break;
            case 8:
                user.setTier("나무 2");
                break;
            case 9:
                user.setTier("나무 1");
                break;

            default:
                throw new IllegalStateException("티어를 구할 수 없음");
        }

        userRepository.save(user);
    }
}
