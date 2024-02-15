package me.seula.greeny.domain.quest.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.quest.dto.QuestDTO;
import me.seula.greeny.domain.quest.entity.QuestEntity;
import me.seula.greeny.domain.quest.repository.QuestRepository;
import me.seula.greeny.domain.user.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestService {

    private final UserRepository userRepository;
    private final QuestRepository questRepository;

    // type = 1 - 성공  | type = 2 - 진행중
    public List<QuestEntity> getQuestList(int type) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        int userId = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User Entity Not Found"))
                .getId();


        if (type == 1){
            return questRepository.findByQuestCompleteEntityListCompleteUserId(userId);
        }
        if (type == 2){
            return getNotCompletedYet(userId);
        }

        return new ArrayList<>();
    }

    public List<QuestEntity> getQuestListWeekly(int type) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        int userId = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User Entity Not Found"))
                .getId();

        List<QuestEntity> questList = new ArrayList<>();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start = now.minusDays(7).withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime end = now.withHour(23).withMinute(59).withSecond(59).withNano(999999999);

        if (type == 1) {
            questList = questRepository.findByQuestCompleteEntityListCompleteUserId(userId);
        }
        if (type == 2) {
            questList = questRepository.findByQuestCompleteEntityListCompleteUserIdIsNullOrQuestCompleteEntityListCompleteUserIdNot(userId);
        }

        return questList.stream()
                .filter(quest -> quest.getCreatedAt().isAfter(start) && quest.getCreatedAt().isBefore(end))
                .toList();
    }

    public List<QuestEntity> getQuestListNewly(int type) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        int userId = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User Entity Not Found"))
                .getId();

        List<QuestEntity> questList = new ArrayList<>();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start = now.minusDays(3).withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime end = now.withHour(23).withMinute(59).withSecond(59).withNano(999999999);

        if (type == 1) {
            questList = questRepository.findByQuestCompleteEntityListCompleteUserId(userId);
        }
        if (type == 2) {
            questList = getNotCompletedYet(userId);
        }

        return questList.stream()
                .filter(quest -> quest.getCreatedAt().isAfter(start) && quest.getCreatedAt().isBefore(end))
                .toList();
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

    public List<QuestEntity> getNotCompletedYet(int userId) {
        List<QuestEntity> completedQuestList = questRepository.findByQuestCompleteEntityListCompleteUserId(userId);
        List<QuestEntity> questList = questRepository.findAll();

        questList.removeAll(completedQuestList);

        return questList;
    }
}
