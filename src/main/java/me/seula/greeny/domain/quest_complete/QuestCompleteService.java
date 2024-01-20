package me.seula.greeny.domain.quest_complete;

import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.quest.QuestEntity;
import me.seula.greeny.domain.quest.QuestRepository;
import me.seula.greeny.domain.user.UserRepository;
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
