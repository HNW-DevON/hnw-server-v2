package me.seula.hnw.service;

import me.seula.hnw.domain.ProductEntity;
import me.seula.hnw.dto.ProductDTO;
import me.seula.hnw.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

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
