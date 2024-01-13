package me.seula.greeny.service;

import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.QuestCompleteEntity;
import me.seula.greeny.domain.QuestEntity;
import me.seula.greeny.domain.UserEntity;
import me.seula.greeny.repository.QuestCompleteRepository;
import me.seula.greeny.repository.QuestRepository;
import me.seula.greeny.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestCompleteService {

    private final QuestCompleteRepository questCompleteRepository;
    private final QuestRepository questRepository;
    private final UserRepository userRepository;

    public void completeQuest(int id, Authentication authentication){
        QuestEntity questEntity = questRepository.findById(id).get();
        int userId = userRepository.findByUsername(authentication.getName()).get().getId();

        QuestCompleteEntity questCompleteEntity = questCompleteRepository.save(QuestCompleteEntity.builder()
                .completeUserId(userId)
                .questEntity(questEntity)
                .build());

        questEntity.addQuestComplete(questCompleteEntity);
        questRepository.save(questEntity);

    }

}
