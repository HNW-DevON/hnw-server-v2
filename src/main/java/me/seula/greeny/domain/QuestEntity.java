package me.seula.greeny.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
public class QuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
        퀘스트 이름
    */
    private String questName;

    /*
        퀘스트 설명
    */
    private String questDesc;

    /*
        현재 깬 사람 수
    */
    private String current;

    /*
        퀘스트 인원 수
    */
    private String limit;

    @Builder
    public QuestEntity(String questName, String questDesc) {
        this.questName = questName;
        this.questDesc = questDesc;
    }
}
