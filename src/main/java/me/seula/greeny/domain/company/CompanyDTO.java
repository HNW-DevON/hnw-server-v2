package me.seula.greeny.domain.company;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyDTO {

    /*
        회사 이름
    */
    private String companyName;

    /*
        회사 주소
     */
    private String companyDesc;

    /*
        회사 카테고리
    */
    private List<String> companyCategory;
}
