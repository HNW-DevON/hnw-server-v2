package me.seula.greeny.domain.event;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void createEvent(EventDTO eventDTO) {
        eventService.createEvent(eventDTO);
    }
}
