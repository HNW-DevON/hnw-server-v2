package me.seula.greeny.domain.point.repository;

import me.seula.greeny.domain.point.entity.PointEntity;
import me.seula.greeny.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<PointEntity, Integer> {
    Boolean existsByProductIdAndUser(String productId, UserEntity user);
}
