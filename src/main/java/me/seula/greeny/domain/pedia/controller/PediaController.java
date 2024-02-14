package me.seula.greeny.domain.pedia.controller;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.pedia.service.PediaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "도감", description = "도감 관련 API 모음")
@RestController
@RequestMapping("/pedia")
@RequiredArgsConstructor
public class PediaController {

    private final PediaService pediaService;

    /*
        자신의 도감 조회
    */
    @Operation(summary = "도감 조회", description = "자신의 도감을 조회합니다")
    @GetMapping
    public List<JsonNode> getPedia() {
        return pediaService.getPedia();
    }

}
