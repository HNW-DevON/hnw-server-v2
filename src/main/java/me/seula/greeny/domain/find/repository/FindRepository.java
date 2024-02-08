package me.seula.greeny.domain.find.repository;

import me.seula.greeny.domain.pedia.entity.PediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FindRepository extends JpaRepository<PediaEntity, Long> {
    @Query("SELECT DISTINCT r.productId FROM PediaEntity r WHERE r.username <> :username")
    List<Long> findDistinctProductIdsByUsernameNot(String username);
}
