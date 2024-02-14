package me.seula.greeny.domain.find.repository;

import me.seula.greeny.domain.pedia.entity.PediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FindRepository extends JpaRepository<PediaEntity, Long> {
    @Query("SELECT DISTINCT productId FROM PediaEntity")
    List<Long> findDistinctProductId();

    @Query(value = "SELECT DISTINCT * from PediaEntity ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<PediaEntity> findRandomDistinct();

}
