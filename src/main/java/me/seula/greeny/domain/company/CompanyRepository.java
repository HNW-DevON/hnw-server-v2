package me.seula.greeny.domain.company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
    Boolean existsByCompanyName(String companyName);
}
