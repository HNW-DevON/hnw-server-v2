package me.seula.greeny.domain.quest_complete.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.seula.greeny.domain.quest.entity.QuestEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestCompleteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
        1:N 관계
        QuestEntity 연결
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quest_id")
    private QuestEntity questEntity;

    /*
        성공한 유저 아이디
    */
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
