package me.seula.hnw.controller;

import me.seula.hnw.domain.CompanyEntity;
import me.seula.hnw.dto.CompanyDTO;
import me.seula.hnw.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /*
        회사 전체 리스트 반환
    */
    @GetMapping("/company")
    public List<CompanyEntity> getCompanyList() {
        return companyService.getCompanyList();
    }

    /*
        회사 정보 받아오기
    */
    @GetMapping("/company/{companyName}")
    public CompanyEntity getCompany(@PathVariable("companyName") String companyName) {
        return companyService.getCompany(companyName);
    }

    @PostMapping("/company/create")
    public void createCompany(CompanyDTO companyDTO) {
        companyService.createCompany(companyDTO);
    }
}
