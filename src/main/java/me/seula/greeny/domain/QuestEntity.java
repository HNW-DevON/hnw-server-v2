package me.seula.greeny.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Builder
    public QuestEntity(String questName, String questDesc, int questCurrent, int questLimit) {
        this.questName = questName;
        this.questDesc = questDesc;
        this.questCurrent = questCurrent;
        this.questLimit = questLimit;
    }
}
