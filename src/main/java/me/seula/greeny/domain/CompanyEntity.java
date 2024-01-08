package me.seula.greeny.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
        회사 이름
    */
    private String companyName;

    /*
        회사 주소
    */
    private String companyAddress;

    @Builder
    public CompanyEntity(String companyName, String companyAddress) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }
}
