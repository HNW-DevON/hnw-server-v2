package me.seula.greeny.domain.pedia.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.pedia.entity.PediaEntity;
import me.seula.greeny.domain.pedia.repository.PediaRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PediaService {

    private final PediaRepository pediaRepository;
    private final RestTemplate restTemplate;

    public List<JsonNode> getPedia() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        List<String> productIdList = pediaRepository.findProductIdByUsername(auth.getName());
        List<JsonNode> productList = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> http = new HttpEntity<>(headers);

        for (String aString : productIdList) {
            JsonNode result = restTemplate.exchange("https://m.retaildb.or.kr/service/product_info/search/" + aString, HttpMethod.GET, http, JsonNode.class).getBody();
            productList.add(result);
        }

        return productList;
    }

    public void savePedia(String productId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        PediaEntity pediaEntity = PediaEntity.builder()
                .productId(productId)
                .username(username)
                .build();

        pediaRepository.save(pediaEntity);
    }

    public Boolean isExist(String productId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        return pediaRepository.findByProductIdAndUsername(productId, username).isEmpty();
    }

    public int getCount(String productId) {
        return pediaRepository.countByProductId(productId);
    }

}
