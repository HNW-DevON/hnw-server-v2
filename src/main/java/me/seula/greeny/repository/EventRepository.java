package me.seula.greeny.repository;

import me.seula.greeny.domain.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<EventEntity, Integer> {
    List<EventEntity> findAll();

    EventEntity findById(int eventId);
}
