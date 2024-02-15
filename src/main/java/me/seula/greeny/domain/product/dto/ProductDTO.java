package me.seula.greeny.domain.product.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private int count;

    private JsonNode product;

}
