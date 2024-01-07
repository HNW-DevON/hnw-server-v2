package me.seula.hnw.controller;

import me.seula.hnw.domain.CompanyEntity;
import me.seula.hnw.domain.ProductEntity;
import me.seula.hnw.dto.CompanyDTO;
import me.seula.hnw.service.CompanyService;
import me.seula.hnw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    private final CompanyService companyService;
    private final ProductService productService;

    @Autowired
    public CompanyController(CompanyService companyService, ProductService productService) {
        this.companyService = companyService;
        this.productService = productService;
    }

    @GetMapping("/company")
    public List<CompanyEntity> getCompanyList() {
        return companyService.getCompanyList();
    }

    @GetMapping("/company/{companyName}")
    public CompanyEntity getCompany(@PathVariable("companyName") String companyName) {
        return companyService.getCompany(companyName);
    }

    @PostMapping("/company/create")
    public void createCompany(CompanyDTO companyDTO) {
        companyService.createCompany(companyDTO);
    }

    @GetMapping("/company/{companyName}/products")
    public List<ProductEntity> getCompanyProduct(@PathVariable("companyName") String companyName) {
        return productService.getCompanyProduct(companyName);
    }
}
