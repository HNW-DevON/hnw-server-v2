package me.seula.greeny.repository;

import me.seula.greeny.domain.QuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestRepository extends JpaRepository<QuestEntity, Integer> {
    List<QuestEntity> findByQuestCompleteEntityListCompleteUserId(int userId);

    List<QuestEntity> findByQuestCompleteEntityListCompleteUserIdIsNullOrQuestCompleteEntityListCompleteUserIdNot(int userId);
}
