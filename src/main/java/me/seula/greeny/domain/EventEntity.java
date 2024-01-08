package me.seula.greeny.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
        이벤트 이름
    */
    private String eventName;

    /*
        이벤트 설명
    */
    private String eventDesc;

    /*
        개최 회사 이름
    */
    private String companyName;

    @Builder
    public EventEntity(String eventName, String eventDesc, String companyName) {
        this.eventName = eventName;
        this.eventDesc = eventDesc;
        this.companyName = companyName;
    }
}
