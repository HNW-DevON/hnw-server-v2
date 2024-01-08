package me.seula.greeny.domain;

import jakarta.persistence.*;
import lombok.*;

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
        회사 주소
    */
    @Column(nullable = false)
    private String companyAddress;

    @Builder
    public CompanyEntity(String companyName, String companyAddress) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }
}
