package me.seula.greeny.domain.company.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.company.dto.CompanyDTO;
import me.seula.greeny.domain.company.entity.CompanyEntity;
import me.seula.greeny.domain.company.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "회사", description = "사회적 기업 관련 API 모음")
@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    /*
        전체 회사 리스트
    */
    @Operation(summary = "전체 회사 조회", description = "회사 전체 리스트를 가져옵니다")
    @GetMapping
    public List<CompanyEntity> getCompanyList() {
        return companyService.getCompanyList();
    }

    /*
        특정 회사 조회
    */
    @Operation(summary = "특정 회사 조회", description = "특정 회사 정보를 조회합니다")
    @GetMapping("/{companyId}")
    public CompanyEntity getCompany(@PathVariable("companyId") int companyId) {
        return companyService.getCompany(companyId);
    }

    /*
        사회적 기업 등록
    */
    @Operation(summary = "사회적 기업 등록", description = "회사를 사회적 기업으로 등록합니다")
    @PostMapping
    public String createCompany(@RequestBody CompanyDTO companyDTO) {
        companyService.createCompany(companyDTO);

        return "{}";
    }

    /*
        오늘의 사회적 기업 조회
    */
    @Operation(summary = "오늘의 사회적 기업", description = "오늘의 사회적 기업 리스트를 가져옵니다")
    @GetMapping("/daily")
    public List<CompanyEntity> getCompanyListDaily() {
        return companyService.getCompanyListDaily();
    }

    /*
        카테고리 별 기업 리스트 조회
    */
    @Operation(summary = "카테고리 기업 조회", description = "회사를 카테고리로 조회합니다")
    @GetMapping("/category/{categoryName}")
    public List<CompanyEntity> getCompanyListByCategory(@PathVariable("categoryName") String categoryName) {
        return companyService.getCompanyListByCategory(categoryName);
    }

}
