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
public class AddCompanyRequest {

    private String name;
    private String businessNumber;
    private String address;

    public Company toEntity() {
        return Company.builder()
            .name(name)
            .businessNumber(businessNumber)
            .address(address)
            .build();
    }

}
