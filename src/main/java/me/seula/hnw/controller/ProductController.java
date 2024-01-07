package me.seula.hnw.controller;

import me.seula.hnw.domain.ProductEntity;
import me.seula.hnw.dto.ProductDTO;
import me.seula.hnw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public List<ProductEntity> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/product/{productName}")
    public ProductEntity getProduct(@PathVariable("productName") String productName) {
        return productService.getProduct(productName);
    }

    @PostMapping("/product/create")
    public void createProduct(ProductDTO productDTO) {
        productService.createProduct(productDTO);
    }
}
