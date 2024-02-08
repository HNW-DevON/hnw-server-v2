package me.seula.greeny.domain.user.service;

import me.seula.greeny.domain.point.entity.PointEntity;
import me.seula.greeny.domain.user.dto.EditDTO;
import me.seula.greeny.domain.user.dto.ExpDTO;
import me.seula.greeny.domain.user.dto.RegisterDTO;
import me.seula.greeny.domain.user.dto.UserDTO;
import me.seula.greeny.domain.user.entity.UserEntity;
import me.seula.greeny.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.UrlResource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${file.path}")
    private String uploadPath;

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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User Entity Not Found"));

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        String filePath = uploadPath + fileName;

        File dest = new File(filePath);
        file.transferTo(dest);

        user.setImagePath(filePath);
        userRepository.save(user);
    }

    public Resource getImage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User Entity Not Found"));


        try {
            Path imagePath = Paths.get(uploadPath).resolve(user.getImagePath()).normalize();
            Resource resource = new UrlResource(imagePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Image not found");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Image not found", e);
        }
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

        ExpDTO expDTO = new ExpDTO();

        expDTO.setTier(user.getTier());
        expDTO.setLeft(user.getTotalExp() % 100);

        return expDTO;
    }

    public void updateUserTier() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User Entity Not Found"));

        int tier = user.getTotalExp() / 100;

        switch (tier) {
            case 0:
                user.setTier("씨앗 3");
                break;
            case 1:
                user.setTier("씨앗 2");
                break;
            case 2:
                user.setTier("씨앗 1");

            case 3:
                user.setTier("새싹 3");
                break;
            case 4:
                user.setTier("새싹 2");
                break;
            case 5:
                user.setTier("새싹 1");
                break;

            case 6:
                user.setTier("나무 3");
                break;
            case 7:
                user.setTier("나무 2");
                break;
            case 8:
                user.setTier("나무 1");
                break;

            default:
                throw new IllegalStateException("티어를 구할 수 없음");
        }

        userRepository.save(user);
    }

    public void editUser(EditDTO editDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User Entity Not Found"));

        user.setName(editDTO.getName());

        userRepository.save(user);
    }

    public UserDTO getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User Entity Not Found"));
        UserDTO userDTO = new UserDTO();

        userDTO.setName(user.getName());
        userDTO.setUsername(user.getUsername());
        userDTO.setTier(user.getTier());
        userDTO.setBirth(user.getBirth());
        userDTO.setPointHistory(user.getPointHistory().stream().map(PointEntity::toDomain).toList());
        return userDTO;
    }
}