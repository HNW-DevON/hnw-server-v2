package me.seula.greeny.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
        이벤트 이름
    */
    @Column(nullable = false)
    private String eventName;

    /*
        이벤트 설명
    */
    @Column(nullable = false)
    private String eventDesc;

    /*
        개최 회사 이름
    */
    @Column(nullable = false)
    private String companyName;

    @Builder
    public EventEntity(
            String eventName,
            String eventDesc,
            String companyName)
    {
        this.eventName = eventName;
        this.eventDesc = eventDesc;
        this.companyName = companyName;
    }
}
