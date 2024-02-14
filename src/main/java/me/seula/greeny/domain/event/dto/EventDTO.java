package me.seula.greeny.domain.event.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDTO {

    /*
        이벤트 이름
    */
    private String eventName;

    /*
        이벤트 설명
    */
    private String eventDesc;

    /*
        개최 회사 ID
    */
    private int companyId;

}
