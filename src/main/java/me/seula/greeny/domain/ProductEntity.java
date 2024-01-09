package me.seula.greeny.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
        제품 이름
    */
    @Column(nullable = false)
    private String productName;

    /*
        제품 설명
    */
    @Column(nullable = false)
    private String productDesc;

    /*
        만든 회사
    */
    @ManyToOne
    @JoinColumn(nullable = false)
    private CompanyEntity company;

    @Builder
    public ProductEntity(
            String productName,
            String productDesc,
            CompanyEntity company)
    {
        this.productName = productName;
        this.productDesc = productDesc;
        this.company = company;
    }
}
