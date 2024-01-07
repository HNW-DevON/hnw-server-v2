package me.seula.hnw.repository;

import me.seula.hnw.domain.QuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestRepository extends JpaRepository<QuestEntity, Integer> {

    List<QuestEntity> findAll();

    QuestEntity findById(int questId);

}
