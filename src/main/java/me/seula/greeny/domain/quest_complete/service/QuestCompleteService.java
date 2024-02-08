package me.seula.greeny.domain.quest_complete.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.quest.entity.QuestEntity;
import me.seula.greeny.domain.quest.repository.QuestRepository;
import me.seula.greeny.domain.quest_complete.entity.QuestCompleteEntity;
import me.seula.greeny.domain.quest_complete.repository.QuestCompleteRepository;
import me.seula.greeny.domain.user.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestCompleteService {

    private final QuestCompleteRepository questCompleteRepository;
    private final QuestRepository questRepository;
    private final UserRepository userRepository;

    public void completeQuest(int id, Authentication authentication){
        QuestEntity questEntity = questRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Quest Entity Not Found"));
        int userId = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new EntityNotFoundException("User Entity Not Found"))
                .getId();

        QuestCompleteEntity questCompleteEntity = questCompleteRepository.save(QuestCompleteEntity.builder()
                .completeUserId(userId)
                .questEntity(questEntity)
                .build());

        questEntity.addQuestComplete(questCompleteEntity);
        questRepository.save(questEntity);

    }

}
