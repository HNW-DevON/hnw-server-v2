package me.seula.greeny.domain.pedia;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<PediaEntity> getPedia() {
        return pediaService.getPedia();
    }

}
