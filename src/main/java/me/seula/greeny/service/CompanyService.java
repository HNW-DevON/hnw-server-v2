package me.seula.greeny.service;

import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.CompanyEntity;
import me.seula.greeny.dto.CompanyDTO;
import me.seula.greeny.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyEntity getCompany(String companyName) {
        return companyRepository.findByCompanyName(companyName);
    }

    public List<CompanyEntity> getCompanyList() {
        return companyRepository.findAll();
    }

    public void createCompany(CompanyDTO companyDTO) {

        String companyName = companyDTO.getCompanyName();
        String companyAddress = companyDTO.getCompanyAddress();


        Boolean ifExist = companyRepository.existsByCompanyName(companyName);

        if (ifExist) {
            return;
        }

        CompanyEntity companyEntity = new CompanyEntity();

        companyEntity.setCompanyName(companyName);
        companyEntity.setCompanyAddress(companyAddress);

        companyRepository.save(companyEntity);
    }
}
