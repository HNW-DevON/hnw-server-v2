package me.seula.greeny.controller;

import lombok.RequiredArgsConstructor;
import me.seula.greeny.service.QuestCompleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
