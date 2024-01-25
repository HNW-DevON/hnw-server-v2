package me.seula.greeny.domain.point;

import me.seula.greeny.domain.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<PointEntity, Integer> {
    Boolean existsByProductIdAndUser(String productId, UserEntity user);
}
