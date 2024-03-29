package me.seula.greeny.domain.quest_complete.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.quest_complete.service.QuestCompleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Tag(name = "퀘스트 완료", description = "퀘스트 완료 관련 API 모음")
@RestController
@RequiredArgsConstructor
@RequestMapping("/quest")
public class QuestCompleteController {

    private final QuestCompleteService questCompleteService;

    /*
        퀘스트 완료
    */
    @Operation(summary = "퀘스트 완료", description = "퀘스트를 완료 표시합니다")
    @GetMapping("/complete/{id}")
    public ResponseEntity<?> completeQuest(@PathVariable int id){
        questCompleteService.completeQuest(id);
        return ResponseEntity.ok("{}");
    }


}
