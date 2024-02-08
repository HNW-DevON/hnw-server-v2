package me.seula.greeny.domain.pedia.repository;

import me.seula.greeny.domain.pedia.entity.PediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PediaRepository extends JpaRepository<PediaEntity, Integer> {

    Optional<PediaEntity> findByProductIdAndUsername(String productId, String username);

    List<PediaEntity> findAllByUsername(String username);

}