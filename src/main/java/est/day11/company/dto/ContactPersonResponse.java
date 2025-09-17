package est.day11.company.dto;

import est.day11.company.entity.Company;
import est.day11.company.entity.ContactPerson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactPersonResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private CompanyResponse companyResponse;

    public ContactPersonResponse(ContactPerson contactPerson) {
        this.id = contactPerson.getId();
        this.name = contactPerson.getName();
        this.email = contactPerson.getEmail();
        this.phone = contactPerson.getPhone();
        this.companyResponse = new CompanyResponse(contactPerson.getCompany());
    }


}
