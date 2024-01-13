package me.seula.greeny.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.QuestEntity;
import me.seula.greeny.dto.QuestDTO;
import me.seula.greeny.repository.QuestRepository;
import me.seula.greeny.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestService {

    private final UserRepository userRepository;
    private final QuestRepository questRepository;

    // type = 1 - 성공  | type = 2 - 진행중
    public List<QuestEntity> getQuestList(int type, Authentication authentication) {
        int userId = userRepository.findByUsername(authentication.getName()).get().getId();

        if (type == 1){
            return questRepository.findByQuestCompleteEntityListCompleteUserId(userId);
        }
        if (type == 2){
            return questRepository.findByQuestCompleteEntityListCompleteUserIdIsNullOrQuestCompleteEntityListCompleteUserIdNot(userId);
        }

        return null;
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
