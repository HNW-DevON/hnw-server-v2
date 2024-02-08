package me.seula.greeny.domain.company.repository;

import me.seula.greeny.domain.company.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
    Boolean existsByCompanyName(String companyName);

    List<CompanyEntity> findByCompanyCategoryContaining(String companyCategory);
}
