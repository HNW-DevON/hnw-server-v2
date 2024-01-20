package me.seula.greeny.domain.company;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public List<CompanyEntity> getCompanyList() {
        return companyService.getCompanyList();
    }

    @GetMapping("/{companyName}")
    public CompanyEntity getCompany(@PathVariable("companyName") int companyId) {
        return companyService.getCompany(companyId);
    }

    @PostMapping
    public void createCompany(CompanyDTO companyDTO) {
        companyService.createCompany(companyDTO);
    }

}
