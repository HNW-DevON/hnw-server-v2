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

    private String productName;

    private String productDesc;

    private String companyName;

    @Builder
    public ProductEntity(String productName, String productDesc, String companyName) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.companyName = companyName;
    }
}
