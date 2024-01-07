package me.seula.hnw.repository;

import me.seula.hnw.domain.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
    Boolean existsByCompanyName(String companyName);

    CompanyEntity findByCompanyName(String companyName);

    List<CompanyEntity> findAll();
}
