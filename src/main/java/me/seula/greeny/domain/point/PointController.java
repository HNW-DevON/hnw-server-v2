package me.seula.greeny.domain.point;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "포인트", description = "포인트 관련 API 모음")
@RestController
@RequestMapping("/point")
@RequiredArgsConstructor
public class PointController {

    private final PointService pointService;

    /*
        포인트 적립
    */
    @Operation(summary = "인식 포인트 적립", description = "제품 인식 포인트를 적립합니다 (30 포인트)")
    @GetMapping("/get/{productId}")
    public String get_point(@PathVariable("productId") String productId) {
        pointService.updatePoint(30, productId);

        return "{}";
    }
}
