package me.seula.greeny.domain.quest;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quest")
@RequiredArgsConstructor
public class QuestController {

    private final QuestService questService;

    @GetMapping("/")
    public List<QuestEntity> getQuestList(
            int type,
            Authentication authentication){
        return questService.getQuestList(type, authentication);
    }

    @GetMapping("/{questId}")
    public QuestEntity getQuest(@PathVariable("questId") int questId) {
        return questService.getQuest(questId);
    }

    @PostMapping
    public void createQuest(QuestDTO questDTO) {
        questService.createQuest(questDTO);
    }
}
