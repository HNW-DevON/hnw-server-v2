package me.seula.greeny.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.CompanyEntity;
import me.seula.greeny.dto.CompanyDTO;
import me.seula.greeny.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyEntity getCompany(String companyName) {
        return companyRepository.findByCompanyName(companyName)
                .orElseThrow(() -> new EntityNotFoundException("Company Not Found : " + companyName));
    }

    public List<CompanyEntity> getCompanyList() {
        return companyRepository.findAll();
    }

    public void createCompany(CompanyDTO companyDTO) {
        String companyName = companyDTO.getCompanyName();

        if (companyRepository.findByCompanyName(companyName).isPresent()) {
            return;
        }

        companyRepository.save(CompanyEntity.builder()
                .companyName(companyName)
                .companyAddress(companyDTO.getCompanyAddress())
                .contribution(0)
                .build()
        );
    }
}
