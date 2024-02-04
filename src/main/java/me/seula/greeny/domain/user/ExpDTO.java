package me.seula.greeny.domain.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExpDTO {

    private String tier;

    private int left;

}
