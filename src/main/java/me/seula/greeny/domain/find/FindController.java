package me.seula.greeny.domain.find;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/find")
@RequiredArgsConstructor
public class FindController {
    private final FindService findService;

    @GetMapping
    public List<Long> getRecommendations(@RequestParam String username) {
        return findService.findDistinctProductIdsByUsernameNot(username);
    }
}
