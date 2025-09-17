package est.day11.company.service;

import est.day11.company.dto.AddCompanyRequest;
import est.day11.company.dto.CompanyResponse;
import est.day11.company.entity.Company;
import est.day11.company.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public int businessNumberCheck(String businessNumber) {
        Company company = companyRepository.findByBusinessNumber(businessNumber);
        if (company == null) {
            return 0;
        } else {
            return 1;
        }
    }

    public Company addCompany(AddCompanyRequest addCompanyRequest) {
        int check = businessNumberCheck(addCompanyRequest.getBusinessNumber());
        if (check == 0) {
            return companyRepository.save(addCompanyRequest.toEntity());
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    public List<CompanyResponse> getCompanies() {
        return companyRepository.findAll().stream()
            .map(company -> new CompanyResponse(company))
            .toList();
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    public Company updateCompany(Long id, AddCompanyRequest addCompanyRequest) {
        Company company = companyRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        company.updateCompany(addCompanyRequest.getName()
            , addCompanyRequest.getBusinessNumber()
            , addCompanyRequest.getAddress());

        return company;
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
