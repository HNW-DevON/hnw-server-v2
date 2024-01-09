package me.seula.greeny.controller;

import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.PediaEntity;
import me.seula.greeny.repository.PediaRepository;
import me.seula.greeny.service.PediaService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
