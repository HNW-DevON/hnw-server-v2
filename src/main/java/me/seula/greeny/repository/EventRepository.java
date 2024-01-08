package me.seula.greeny.repository;

import me.seula.greeny.domain.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<EventEntity, Integer> {
    Optional<EventEntity> findById(int eventId);

    List<EventEntity> findAll();
}
