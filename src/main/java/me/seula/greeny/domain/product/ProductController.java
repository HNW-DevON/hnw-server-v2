package me.seula.greeny.domain.product;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.pedia.PediaService;
import me.seula.greeny.domain.point.PointService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final PediaService pediaService;
    private final PointService pointService;
    private final RestTemplate restTemplate;

    @GetMapping("/{productId}")
    public String getProduct(@PathVariable("productId") String productId) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> http = new HttpEntity<>(headers);
        JsonNode result = restTemplate.exchange("https://m.retaildb.or.kr/service/product_info/search/" + productId, HttpMethod.GET, http, JsonNode.class).getBody();

        if (Objects.requireNonNull(result).get("code").asText().equals("null")) {
            if (pediaService.isExist(productId)) {
                pediaService.savePedia(productId);
            }

            /*
                포인트를 받은 기록이 있는가?
            */
            ((ObjectNode) result).put("isGotPoint", pointService.isGotPoint(productId));

            return result.toString();
        }

        return null;
    }
}

