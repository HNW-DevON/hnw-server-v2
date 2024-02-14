package me.seula.greeny.domain.find.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FindDTO {

    private String username;

    private LocalDateTime addedAt;

    private JsonNode product;

}
