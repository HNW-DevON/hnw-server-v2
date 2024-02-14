package me.seula.greeny.domain.product.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.pedia.service.PediaService;
import me.seula.greeny.domain.point.service.PointService;
import me.seula.greeny.domain.user.service.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Tag(name = "제품", description = "제품 관련 API 모음")
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final PediaService pediaService;
    private final PointService pointService;
    private final UserService userService;
    private final RestTemplate restTemplate;

    /*
        제품 조회 (도감 등록)
    */
    @Operation(summary = "제품 인식 (조회)", description = "제품 정보를 반환합니다 (도감 등록)")
    @GetMapping("/{productId}")
    public String getProduct(@PathVariable("productId") String productId) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> http = new HttpEntity<>(headers);
        JsonNode result = restTemplate.exchange("https://m.retaildb.or.kr/service/product_info/search/" + productId, HttpMethod.GET, http, JsonNode.class).getBody();

        if (Objects.requireNonNull(result).get("code").asText().equals("null")) {
            if (pediaService.isExist(productId)) {
                pediaService.savePedia(productId);
                userService.addExp();
                userService.updateUserTier();
            }

            return result.toString();
        }

        return "{}";
    }
}

