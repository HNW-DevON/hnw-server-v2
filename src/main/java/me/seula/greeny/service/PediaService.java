package me.seula.greeny.service;

import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.PediaEntity;
import me.seula.greeny.repository.PediaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PediaService {

    private final PediaRepository pediaRepository;

    public List<PediaEntity> getPedia() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return pediaRepository.findAllByUsername(auth.getName());
    }

    public void savePedia(String productId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        if (pediaRepository.findByProductIdAndUsername(productId, username).isPresent()) {
            return;
        }

        PediaEntity pediaEntity = PediaEntity.builder()
                .productId(productId)
                .username(username)
                .build();

        pediaRepository.save(pediaEntity);
    }

}
