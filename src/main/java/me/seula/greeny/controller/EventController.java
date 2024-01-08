package me.seula.greeny.controller;

import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.EventEntity;
import me.seula.greeny.dto.EventDTO;
import me.seula.greeny.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/event")
    public List<EventEntity> getEventList() {
        return eventService.getEventList();
    }

    @GetMapping("/event/{eventId}")
    public EventEntity getEvent(@PathVariable("eventId") int eventId) {
        return eventService.getEvent(eventId);
    }

    @PostMapping("/event/create")
    public void createEvent(EventDTO eventDTO) {
        eventService.createEvent(eventDTO);
    }
}
