package me.seula.greeny.domain.find.service;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.core.util.Json;
import jakarta.persistence.EntityNotFoundException;
import me.seula.greeny.domain.find.dto.FindDTO;
import me.seula.greeny.domain.find.repository.FindRepository;
import me.seula.greeny.domain.pedia.entity.PediaEntity;
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

    public List<FindDTO> getDailyProducts() {
        List<PediaEntity> productIdList = findRepository.findRandomDistinct();
        List<FindDTO> productList = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> http = new HttpEntity<>(headers);

        for (PediaEntity pediaEntity : productIdList) {
            JsonNode result = restTemplate.exchange("https://m.retaildb.or.kr/service/product_info/search/" + pediaEntity.getProductId(), HttpMethod.GET, http, JsonNode.class).getBody();

            FindDTO findDTO = new FindDTO();

            findDTO.setUsername(pediaEntity.getUsername());
            findDTO.setAddedAt(pediaEntity.getAddedAt());
            findDTO.setProduct(result);

            productList.add(findDTO);
        }

        return productList;
    }
}
