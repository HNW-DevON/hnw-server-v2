package me.seula.greeny.controller;

import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.EventEntity;
import me.seula.greeny.dto.EventDTO;
import me.seula.greeny.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping
    public List<EventEntity> getEventList() {
        return eventService.getEventList();
    }

    @GetMapping("/{eventId}")
    public EventEntity getEvent(@PathVariable("eventId") int eventId) {
        return eventService.getEvent(eventId);
    }

    @PostMapping
    public void createEvent(EventDTO eventDTO) {
        eventService.createEvent(eventDTO);
    }
}
