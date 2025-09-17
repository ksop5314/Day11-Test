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
public class AddContactPersonRequest {

    private String name;
    private String email;
    private String phone;
    private Company company;

    public ContactPerson toEntity() {
        return ContactPerson.builder()
            .name(name)
            .email(email)
            .phone(phone)
            .company(company)
            .build();
    }

}
