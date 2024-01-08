package me.seula.greeny.repository;

import me.seula.greeny.domain.QuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface QuestRepository extends JpaRepository<QuestEntity, Integer> {
    Optional<QuestEntity> findById(int questId);

    List<QuestEntity> findAll();
}
