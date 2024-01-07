package me.seula.hnw.service;

import me.seula.hnw.domain.EventEntity;
import me.seula.hnw.dto.EventDTO;
import me.seula.hnw.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventEntity> getEventList() {
        return eventRepository.findAll();
    }

    public EventEntity getEvent(int eventId) {
        return eventRepository.findById(eventId);
    }

    public void createEvent(EventDTO eventDTO) {
        String eventName = eventDTO.getEventName();
        String eventDesc = eventDTO.getEventDesc();
        String companyName = eventDTO.getCompanyName();

        EventEntity eventEntity = new EventEntity();

        eventEntity.setEventName(eventName);
        eventEntity.setEventDesc(eventDesc);
        eventEntity.setCompanyName(companyName);

        eventRepository.save(eventEntity);
    }

}
