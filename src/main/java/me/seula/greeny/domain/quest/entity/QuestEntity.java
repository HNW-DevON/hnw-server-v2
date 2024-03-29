package me.seula.greeny.domain.quest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.seula.greeny.domain.quest_complete.entity.QuestCompleteEntity;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
        퀘스트 이름
    */
    @Column(nullable = false)
    private String questName;

    /*
        퀘스트 설명
    */
    @Column(nullable = false)
    private String questDesc;

    /*
        현재 깬 사람 수
    */
    @Column(nullable = false)
    private int questCurrent;

    /*
        인원 제한
    */
    @Column(nullable = false)
    private int questLimit;

    /*
        깨면 주는 포인트
    */
    @Column(nullable = false)
    private int questPoint;

    /*
        퀘스트 추가된 시간
    */
    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "questEntity", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<QuestCompleteEntity> questCompleteEntityList = new ArrayList<>();

    @Builder
    public QuestEntity(
            String questName,
            String questDesc,
            int questCurrent,
            int questLimit,
            int questPoint,
            List<QuestCompleteEntity> questCompleteEntityList)
    {
        this.questName = questName;
        this.questDesc = questDesc;
        this.questCurrent = questCurrent;
        this.questLimit = questLimit;
        this.questPoint = questPoint;
        this.questCompleteEntityList = questCompleteEntityList;
        this.createdAt = LocalDateTime.now();
    }

    public void addQuestComplete(QuestCompleteEntity questCompleteEntity) {
        questCompleteEntityList.add(questCompleteEntity);
        questCompleteEntity.addQuestEntity(this);
    }
}
