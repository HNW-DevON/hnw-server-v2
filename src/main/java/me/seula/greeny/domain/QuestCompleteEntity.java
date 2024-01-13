package me.seula.greeny.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestCompleteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quest_id")
    private QuestEntity questEntity;

    @Column(nullable = false)
    private int completeUserId;

    @Builder
    public QuestCompleteEntity(QuestEntity questEntity, int completeUserId) {
        this.questEntity = questEntity;
        this.completeUserId = completeUserId;
    }

    public void addQuestEntity(QuestEntity questEntity) {
        this.questEntity = questEntity;
    }
}
