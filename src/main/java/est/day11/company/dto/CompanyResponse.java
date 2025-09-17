package est.day11.company.dto;

import est.day11.company.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResponse {

    private Long id;
    private String name;
    private String businessNumber;
    private String address;

    public CompanyResponse(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.businessNumber = company.getBusinessNumber();
        this.address = company.getAddress();
    }

}
