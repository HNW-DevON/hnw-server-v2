package me.seula.greeny.domain.pedia.service;

import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.pedia.entity.PediaEntity;
import me.seula.greeny.domain.pedia.repository.PediaRepository;
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

        PediaEntity pediaEntity = PediaEntity.builder()
                .productId(productId)
                .username(username)
                .build();

        pediaRepository.save(pediaEntity);
    }

    public Boolean isExist(String productId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        return pediaRepository.findByProductIdAndUsername(productId, username).isEmpty();
    }

}
