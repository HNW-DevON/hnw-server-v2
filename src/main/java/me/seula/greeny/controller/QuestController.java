package me.seula.greeny.controller;

import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.QuestEntity;
import me.seula.greeny.dto.QuestDTO;
import me.seula.greeny.service.QuestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuestController {

    private final QuestService questService;

    @GetMapping("/quest")
    public List<QuestEntity> getQuestList(){
        return questService.getQuestList();
    }

    @GetMapping("/quest/{questId}")
    public QuestEntity getQuest(@PathVariable("questId") int questId) {
        return questService.getQuest(questId);
    }

    @PostMapping("/quest/create")
    public void createQuest(QuestDTO questDTO) {
        questService.createQuest(questDTO);
    }
}
