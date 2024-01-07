package me.seula.hnw.controller;

import me.seula.hnw.domain.EventEntity;
import me.seula.hnw.dto.EventDTO;
import me.seula.hnw.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

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
