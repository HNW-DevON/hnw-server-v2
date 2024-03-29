package me.seula.greeny.domain.find.controller;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.find.dto.FindDTO;
import me.seula.greeny.domain.find.service.FindService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "탐색", description = "탐색 부분 api 입니다.")
@RestController
@RequestMapping("/find")
@RequiredArgsConstructor
public class FindController {
    private final FindService findService;

    @Operation(summary = "추천 제품 조회", description = "추천 제품 리스트 가져오기")
    @GetMapping
    public List<JsonNode> getRecommendations() {
        return findService.findDistinctProductIdsByUsernameNot();
    }

    @Operation(summary = "오늘의 착한 소비", description = "랜덤으로 제품을 3개 가져옵니다")
    @GetMapping("/daily")
    public List<FindDTO> getDailyProducts() {
        return findService.getDailyProducts();
    }

}
