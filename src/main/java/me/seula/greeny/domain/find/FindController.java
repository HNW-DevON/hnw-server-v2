package me.seula.greeny.domain.find;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
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
    public List<Long> getRecommendations(@RequestParam String username) {
        return findService.findDistinctProductIdsByUsernameNot(username);
    }
}
