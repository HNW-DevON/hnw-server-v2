package me.seula.greeny.domain.point.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class PointDTO {


    private int id;

    /*
        포인트량
    */
    private int point;

    /*
        포인트 받은 제품 ID
    */
    private String productId;

    /*
        업데이트 된 날짜
    */
    private LocalDate addedAt;

}
