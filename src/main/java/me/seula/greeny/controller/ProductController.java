package me.seula.greeny.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final RestTemplate restTemplate;

    @GetMapping("/{productId}")
    public String getProduct(@PathVariable("productId") String productId) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> http = new HttpEntity<>(headers);
        return restTemplate.exchange("https://m.retaildb.or.kr/service/product_info/search/" + productId, HttpMethod.GET, http, String.class).getBody();
    }

}
