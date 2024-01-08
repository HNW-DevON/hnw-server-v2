package me.seula.greeny.controller;

import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.ProductEntity;
import me.seula.greeny.dto.ProductDTO;
import me.seula.greeny.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

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
