package me.seula.greeny.domain.event.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.event.dto.EventDTO;
import me.seula.greeny.domain.event.entity.EventEntity;
import me.seula.greeny.domain.event.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "이벤트", description = "이벤트 관련 API 모음")
@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    /*
        전체 이벤트 리스트
    */
    @Operation(summary = "전체 이벤트 조회", description = "회사 전체 리스트를 조회합니다")
    @GetMapping
    public List<EventEntity> getEventList() {
        return eventService.getEventList();
    }

    /*
        특정 이벤트 조회
    */
    @Operation(summary = "특정 이벤트 조회", description = "특정 이벤트 정보를 조회합니다")
    @GetMapping("/{eventId}")
    public EventEntity getEvent(@PathVariable("eventId") int eventId) {
        return eventService.getEvent(eventId);
    }

    /*
        이벤트 생성
    */
    @Operation(summary = "이벤트 생성", description = "이벤트를 생성합니다")
    @PostMapping
    public String createEvent(@RequestBody EventDTO eventDTO) {
        eventService.createEvent(eventDTO);

        return "{}";
    }
}
