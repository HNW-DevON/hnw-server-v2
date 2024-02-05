package me.seula.greeny.domain.info;

import me.seula.greeny.domain.pedia.PediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<PediaEntity, Integer> {
}
