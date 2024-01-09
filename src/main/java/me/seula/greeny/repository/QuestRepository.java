package me.seula.greeny.repository;

import me.seula.greeny.domain.QuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestRepository extends JpaRepository<QuestEntity, Integer> {
}
