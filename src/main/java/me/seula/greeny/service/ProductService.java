package me.seula.greeny.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.ProductEntity;
import me.seula.greeny.dto.ProductDTO;
import me.seula.greeny.repository.CompanyRepository;
import me.seula.greeny.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CompanyRepository companyRepository;

    public List<ProductEntity> getAllProduct() {
        return productRepository.findAll();
    }

    public List<ProductEntity> getCompanyProduct(int companyId) {
        return productRepository.findAllByCompanyId(
                companyRepository.findById(companyId)
                        .orElse(null)
        );
    }

    public ProductEntity getProduct(int productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product Not Found : " + productId));
    }

    public void createProduct(ProductDTO productDTO) {
        productRepository.save(
                ProductEntity.builder()
                        .productName(productDTO.getProductName())
                        .productDesc(productDTO.getProductDesc())
                        .company(companyRepository.findById(productDTO.getCompanyId())
                                .orElse(null))
                        .build()
        );
    }
}
