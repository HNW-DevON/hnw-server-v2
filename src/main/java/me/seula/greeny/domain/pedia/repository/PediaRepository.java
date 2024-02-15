package me.seula.greeny.domain.pedia.repository;

import me.seula.greeny.domain.pedia.entity.PediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PediaRepository extends JpaRepository<PediaEntity, Integer> {

    Optional<PediaEntity> findByProductIdAndUsername(String productId, String username);

    @Query("SELECT p.productId FROM PediaEntity p WHERE p.username = :username")
    List<String> findProductIdByUsername(String username);

    Integer countByProductId(String productId);

}
