package me.seula.greeny.domain.find.service;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.EntityNotFoundException;
import me.seula.greeny.domain.find.repository.FindRepository;
import me.seula.greeny.domain.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindService {
    private final FindRepository findRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public FindService(FindRepository findRepository, RestTemplate restTemplate) {
        this.findRepository = findRepository;
        this.restTemplate = restTemplate;
    }

    public List<JsonNode> findDistinctProductIdsByUsernameNot() {
        List<Long> productIdList = findRepository.findDistinctProductId();
        List<JsonNode> productList = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> http = new HttpEntity<>(headers);

        for (Long aLong : productIdList) {
            JsonNode result = restTemplate.exchange("https://m.retaildb.or.kr/service/product_info/search/" + aLong, HttpMethod.GET, http, JsonNode.class).getBody();
            productList.add(result);
        }

        return productList;
    }
}
