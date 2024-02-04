package me.seula.greeny.domain.point;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.user.UserEntity;
import me.seula.greeny.domain.user.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PointService {

    private final UserRepository userRepository;
    private final PointRepository pointRepository;

    public void updatePoint(int point, String productId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User Entity Not Found"));

        user.setHasPoint(user.getHasPoint() + point);

        userRepository.save(user);

        PointEntity pointEntity = new PointEntity(point, productId, user);

        pointRepository.save(pointEntity);
    }

    public Boolean isGotPoint(String productId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User Entity Not Found"));

        return pointRepository.existsByProductIdAndUser(productId, user);
    }
}
