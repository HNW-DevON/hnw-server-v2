package me.seula.greeny.domain.quest.repository;

import me.seula.greeny.domain.quest.entity.QuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface QuestRepository extends JpaRepository<QuestEntity, Integer> {
    List<QuestEntity> findByQuestCompleteEntityListCompleteUserId(int userId);

    List<QuestEntity> findByQuestCompleteEntityListCompleteUserIdIsNullOrQuestCompleteEntityListCompleteUserIdNot(int userId);

}
