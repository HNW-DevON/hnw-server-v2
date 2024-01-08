package me.seula.greeny.service;

import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.ProductEntity;
import me.seula.greeny.dto.ProductDTO;
import me.seula.greeny.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductEntity> getAllProduct() {
        return productRepository.findAll();
    }

    public List<ProductEntity> getCompanyProduct(String companyName) {
        return productRepository.findAllByCompanyName(companyName);
    }

    public ProductEntity getProduct(String productName) {
        return productRepository.findByProductName(productName);
    }

    public void createProduct(ProductDTO productDTO) {

        ProductEntity productEntity = new ProductEntity();

        String productName = productDTO.getProductName();
        String productDesc = productDTO.getProductDesc();
        String companyName = productDTO.getCompanyName();

        productEntity.setProductName(productName);
        productEntity.setProductDesc(productDesc);
        productEntity.setCompanyName(companyName);

        productRepository.save(productEntity);
    }
}
