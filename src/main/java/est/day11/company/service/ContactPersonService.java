package est.day11.company.service;

import est.day11.company.dto.AddContactPersonRequest;
import est.day11.company.dto.CompanyResponse;
import est.day11.company.dto.ContactPersonResponse;
import est.day11.company.entity.Company;
import est.day11.company.entity.ContactPerson;
import est.day11.company.repository.CompanyRepository;
import est.day11.company.repository.ContactPersonRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ContactPersonService {

    private final ContactPersonRepository contactPersonRepository;
    private final CompanyRepository companyRepository;

    public ContactPersonService(ContactPersonRepository contactPersonRepository, CompanyRepository companyRepository) {
        this.contactPersonRepository = contactPersonRepository;
        this.companyRepository = companyRepository;
    }

    public ContactPerson addContactPerson(Long id, AddContactPersonRequest addContactPersonRequest) {
        Company company = companyRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // 그냥 AddContactPersonRequest 만 가져온다면 company 데이터가 비어있으니 set으로 data 채워줌.
        addContactPersonRequest.setCompany(company);

        return contactPersonRepository.save(addContactPersonRequest.toEntity());
    }

    public List<ContactPersonResponse> getContactPersons(Long id) {

        Company company = companyRepository.findById(id)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // 여기서도 특정 기업의 담당자의 목록을 특정 기업에서 빼내와서 보내줌.
        List<ContactPersonResponse> cpList = company.getContactPersons().stream()
            .map(cp -> new ContactPersonResponse(cp))
            .toList();

        return cpList;
    }

    public ContactPerson getContactPersonById(Long id) {
        return contactPersonRepository.findById(id)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteContactPerson(Long id) {
        contactPersonRepository.deleteById(id);
    }
}
