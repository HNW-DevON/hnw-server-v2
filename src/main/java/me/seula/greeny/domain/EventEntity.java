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

    private String eventName;

    private String eventDesc;

    private String companyName;

    @Builder
    public EventEntity(String eventName, String eventDesc, String companyName) {
        this.eventName = eventName;
        this.eventDesc = eventDesc;
        this.companyName = companyName;
    }
}
