package me.seula.greeny.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    /*
        제품 이름
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

}
