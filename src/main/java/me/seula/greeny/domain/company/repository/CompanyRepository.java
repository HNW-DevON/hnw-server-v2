package me.seula.greeny.domain.company.repository;

import me.seula.greeny.domain.company.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
    Boolean existsByCompanyName(String companyName);

    List<CompanyEntity> findByCompanyCategoryContaining(String companyCategory);

    @Query(value = "SELECT * FROM CompanyEntity ORDER BY RAND() LIMIT 2", nativeQuery = true)
    List<CompanyEntity> getCompanyListDaily();
}
