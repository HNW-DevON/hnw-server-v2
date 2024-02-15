package me.seula.greeny.domain.quest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.quest.dto.QuestDTO;
import me.seula.greeny.domain.quest.entity.QuestEntity;
import me.seula.greeny.domain.quest.service.QuestService;
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
    @GetMapping
    public List<QuestEntity> getQuestList(int type){
        return questService.getQuestList(type);
    }

    /*
        이번주의 퀘스트 조회
    */
    @Operation(summary = "이번주의 퀘스트", description = "최근 7일 사이에 생성된 퀘스트를 가져옵니다")
    @GetMapping("/weekly")
    public List<QuestEntity> getQuestListWeekly(int type) {
        return questService.getQuestListWeekly(type);
    }

    /*
        새 퀘스트 조회
    */
    @Operation(summary = "새 퀘스트", description = "최근 3일 사이에 생성된 퀘스트를 가져옵니다")
    @GetMapping("/newly")
    public List<QuestEntity> getQuestListNewly(int type) {
        return questService.getQuestListNewly(type);
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
    public String createQuest(@RequestBody QuestDTO questDTO) {
        questService.createQuest(questDTO);

        return "{}";
    }
}
