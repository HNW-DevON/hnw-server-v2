package me.seula.greeny.domain.user.dto;

import lombok.Getter;
import lombok.Setter;
import me.seula.greeny.domain.point.dto.PointDTO;
import me.seula.greeny.domain.point.entity.PointEntity;

import java.util.List;

@Getter
@Setter
public class UserDTO {

    private String username;

    private String name;

    private String birth;

    private String tier;

    private List<PointDTO> pointHistory;



}
