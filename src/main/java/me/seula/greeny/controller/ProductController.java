package me.seula.greeny.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.PediaEntity;
import me.seula.greeny.service.PediaService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final PediaService pediaService;
    private final RestTemplate restTemplate;

    @GetMapping("/{productId}")
    public String getProduct(@PathVariable("productId") String productId) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> http = new HttpEntity<>(headers);
        JsonNode result = restTemplate.exchange("https://m.retaildb.or.kr/service/product_info/search/" + productId, HttpMethod.GET, http, JsonNode.class).getBody();

        if (result.get("code").asText().equals("null")) {
            pediaService.savePedia(productId);
            return result.toString();
        }

        return null;
    }
}

