package me.seula.greeny.service;

import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.EventEntity;
import me.seula.greeny.dto.EventDTO;
import me.seula.greeny.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<EventEntity> getEventList() {
        return eventRepository.findAll();
    }

    public EventEntity getEvent(int eventId) {
        return eventRepository.findById(eventId).get();
    }

    public void createEvent(EventDTO eventDTO) {
        eventRepository.save(EventEntity.builder()
                .eventName(eventDTO.getEventName())
                .eventDesc(eventDTO.getEventDesc())
                .build()
        );
    }
}
