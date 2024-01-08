package me.seula.greeny.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
        제품 설명
    */
    private String productName;

    /*
        제품 설명
    */
    private String productDesc;

    /*
        만든 회사 이름
    */
    private String companyName;

    @Builder
    public ProductEntity(String productName, String productDesc, String companyName) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.companyName = companyName;
    }
}
