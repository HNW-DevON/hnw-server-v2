package me.seula.greeny.domain.find;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindController {
    private final FindService findService;

    @Autowired
    public FindController(FindService findService) {
        this.findService = findService;
    }

    @GetMapping("/find")
    public List<Long> getRecommendations(@RequestParam String username) {
        return findService.findDistinctProductIdsByUsernameNot(username);
    }
}
