package me.seula.greeny.repository;

import me.seula.greeny.domain.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {

    Optional<CompanyEntity> findByCompanyName(String companyName);

    List<CompanyEntity> findAll();
}
