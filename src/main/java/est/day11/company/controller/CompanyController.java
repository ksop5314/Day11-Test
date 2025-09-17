package est.day11.company.controller;

import est.day11.company.dto.AddCompanyRequest;
import est.day11.company.dto.CompanyResponse;
import est.day11.company.entity.Company;
import est.day11.company.service.CompanyService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Company> addCompany(@RequestBody AddCompanyRequest addCompanyRequest) {
        Company com = companyService.addCompany(addCompanyRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(com);
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getAllCompanies() {
        List<CompanyResponse> companyList = companyService.getCompanies();
        return ResponseEntity.status(HttpStatus.OK)
            .body(companyList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> getCompany(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        CompanyResponse companyResponse = new CompanyResponse(company);
        return ResponseEntity.status(HttpStatus.OK)
            .body(companyResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody AddCompanyRequest addCompanyRequest) {
        Company company = companyService.updateCompany(id, addCompanyRequest);
        return ResponseEntity.status(HttpStatus.OK)
            .body(company);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.ok().build();
    }
}
