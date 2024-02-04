package me.seula.greeny.domain.quest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "퀘스트", description = "퀘스트 관련 API 모음")
@RestController
@RequestMapping("/quest")
@RequiredArgsConstructor
public class QuestController {

    private final QuestService questService;

    /*
        임무 전체 조회
    */
    @Operation(summary = "퀘스트 전체 조회", description = "퀘스트 전체 리스트를 반환합니다")
    @GetMapping("/")
    public List<QuestEntity> getQuestList(
            int type,
            Authentication authentication){
        return questService.getQuestList(type, authentication);
    }

    /*
        특정 퀘스트 조회
    */
    @Operation(summary = "특정 퀘스트 조회", description = "특정 퀘스트 정보를 조회합니다")
    @GetMapping("/{questId}")
    public QuestEntity getQuest(@PathVariable("questId") int questId) {
        return questService.getQuest(questId);
    }

    /*
        퀘스트 생성
    */
    @Operation(summary = "퀘스트 생성", description = "퀘스트를 생성합니다")
    @PostMapping
    public void createQuest(@RequestBody QuestDTO questDTO) {
        questService.createQuest(questDTO);
    }
}
