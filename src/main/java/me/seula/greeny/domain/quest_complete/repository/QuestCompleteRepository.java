package me.seula.greeny.domain.quest_complete.repository;

import me.seula.greeny.domain.quest_complete.entity.QuestCompleteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestCompleteRepository extends JpaRepository<QuestCompleteEntity, Integer> {
}
