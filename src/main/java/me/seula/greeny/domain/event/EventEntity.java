package me.seula.greeny.domain.event;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.seula.greeny.domain.company.CompanyEntity;

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
        개최 회사
    */
    @ManyToOne
    @JoinColumn(nullable = false)
    private CompanyEntity company;

    @Builder
    public EventEntity(
            String eventName,
            String eventDesc,
            CompanyEntity company)
    {
        this.eventName = eventName;
        this.eventDesc = eventDesc;
        this.company = company;
    }
}
