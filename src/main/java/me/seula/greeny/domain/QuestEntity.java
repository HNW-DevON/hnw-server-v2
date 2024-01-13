package me.seula.greeny.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    }

    public void addQuestComplete(QuestCompleteEntity questCompleteEntity) {
        questCompleteEntityList.add(questCompleteEntity);
        questCompleteEntity.addQuestEntity(this);
    }
}
