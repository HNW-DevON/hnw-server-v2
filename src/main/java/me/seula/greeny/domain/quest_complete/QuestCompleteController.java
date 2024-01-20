package me.seula.greeny.domain.quest_complete;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quest")
public class QuestCompleteController {

    private final QuestCompleteService questCompleteService;

    @PostMapping("/complete/{id}")
    public ResponseEntity completeQuest(
            Authentication authentication,
            @PathVariable int id){
        questCompleteService.completeQuest(id, authentication);
        return ResponseEntity.ok("OK");
    }


}
