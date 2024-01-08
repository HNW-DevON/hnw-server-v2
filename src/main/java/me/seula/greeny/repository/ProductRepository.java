package me.seula.greeny.repository;

import me.seula.greeny.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    Optional<ProductEntity> findByProductName(String productName);

    List<ProductEntity> findAllByCompanyName(String companyName);

    List<ProductEntity> findAll();
}
