package me.seula.greeny.domain.quest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestDTO {

    /*
        퀘스트 이름
    */
    private String questName;

    /*
        퀘스트 설명
    */
    private String questDesc;

    /*
        인원 제한
    */
    private int questLimit;

    /*
        주는 포인트
    */
    private int questPoint;

}
