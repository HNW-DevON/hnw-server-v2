package me.seula.greeny.controller;

import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.ProductEntity;
import me.seula.greeny.dto.ProductDTO;
import me.seula.greeny.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductEntity> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/{productName}")
    public ProductEntity getProduct(@PathVariable("productName") String productName) {
        return productService.getProduct(productName);
    }

    @PostMapping
    public void createProduct(ProductDTO productDTO) {
        productService.createProduct(productDTO);
    }

}
