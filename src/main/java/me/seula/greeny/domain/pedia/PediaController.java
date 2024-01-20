package me.seula.greeny.domain.pedia;

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

    @GetMapping
    public List<PediaEntity> getPedia() {
        return pediaService.getPedia();
    }

}
