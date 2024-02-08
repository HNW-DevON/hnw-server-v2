package me.seula.greeny.domain.quest.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.quest.dto.QuestDTO;
import me.seula.greeny.domain.quest.entity.QuestEntity;
import me.seula.greeny.domain.quest.repository.QuestRepository;
import me.seula.greeny.domain.user.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestService {

    private final UserRepository userRepository;
    private final QuestRepository questRepository;

    // type = 1 - 성공  | type = 2 - 진행중
    public List<QuestEntity> getQuestList(int type, Authentication authentication) {
        int userId = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new EntityNotFoundException("User Entity Not Found"))
                .getId();

        if (type == 1){
            return questRepository.findByQuestCompleteEntityListCompleteUserId(userId);
        }
        if (type == 2){
            return questRepository.findByQuestCompleteEntityListCompleteUserIdIsNullOrQuestCompleteEntityListCompleteUserIdNot(userId);
        }

        return new ArrayList<>();
    }

    public QuestEntity getQuest(int questId) {
        return questRepository.findById(questId)
                .orElseThrow(() -> new EntityNotFoundException("Quest Not Found : " + questId));
    }

    public void createQuest(QuestDTO questDTO) {
        questRepository.save(QuestEntity.builder()
                .questName(questDTO.getQuestName())
                .questDesc(questDTO.getQuestDesc())
                .questPoint(questDTO.getQuestPoint())
                .questCurrent(0)
                .questLimit(questDTO.getQuestLimit())
                .build()
        );
    }
}
