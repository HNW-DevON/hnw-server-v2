package me.seula.greeny.domain.company.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.company.dto.CompanyDTO;
import me.seula.greeny.domain.company.entity.CompanyEntity;
import me.seula.greeny.domain.company.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyEntity getCompany(int companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new EntityNotFoundException("Company Not Found : " + companyId));
    }

    public List<CompanyEntity> getCompanyList() {
        return companyRepository.findAll();
    }

    public void createCompany(CompanyDTO companyDTO) {
        String companyName = companyDTO.getCompanyName();

        if (companyRepository.existsByCompanyName(companyName)) {
            return;
        }

        companyRepository.save(CompanyEntity.builder()
                .companyName(companyName)
                .companyDesc(companyDTO.getCompanyDesc())
                .companyCategory(companyDTO.getCompanyCategory())
                .build()
        );
    }

    public List<CompanyEntity> getCompanyListByCategory(String companyCategory) {
        return companyRepository.findByCompanyCategoryContaining(companyCategory);
    }

    public List<CompanyEntity> getCompanyListDaily() {
        return companyRepository.getCompanyListDaily();
    }
}
