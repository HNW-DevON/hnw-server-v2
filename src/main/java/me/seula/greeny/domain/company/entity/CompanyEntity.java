package me.seula.greeny.domain.company.entity;

import jakarta.persistence.*;
import lombok.*;
import me.seula.greeny.domain.event.entity.EventEntity;

import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
        회사 이름
    */
    @Column(nullable = false)
    private String companyName;

    /*
        회사 설명
    */
    @Column(nullable = false)
    private String companyDesc;

    /*
        회사 카테고리
    */
    @Setter
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> companyCategory;

    /*
        회사 주관 이벤트
    */
    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<EventEntity> event;

    @Builder
    public CompanyEntity(
            String companyName,
            String companyDesc,
            List<String> companyCategory
    )
    {
        this.companyName = companyName;
        this.companyDesc = companyDesc;
        this.companyCategory = companyCategory;
    }
}
