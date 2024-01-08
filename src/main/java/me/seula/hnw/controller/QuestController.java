package me.seula.hnw.controller;

import lombok.RequiredArgsConstructor;
import me.seula.hnw.domain.QuestEntity;
import me.seula.hnw.dto.QuestDTO;
import me.seula.hnw.service.QuestService;
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
    public QuestEntity getProduct(@PathVariable("questId") int questId) {
        return questService.getQuest(questId);
    }

    @PostMapping("/quest/create")
    public void createProduct(QuestDTO questDTO) {
        questService.createQuest(questDTO);
    }
}
