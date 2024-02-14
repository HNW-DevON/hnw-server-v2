package me.seula.greeny.domain.event.repository;

import me.seula.greeny.domain.event.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Integer> {
}
