package est.day11.company.dto;

import est.day11.company.entity.Company;
import est.day11.company.entity.ContactPerson;
import jakarta.validation.constraints.Email;
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

    // Spring Boot 에서 지원하는 Email 유효성검사 어노테이션
    // Entity에 쓰는건 예상치 못한 오류들을 발생시킬 수 있어 DTO 쪽에 명시하는 것이 좋다고 함.
    @Email(message = "올바른 이메일 형식이 아닙니다.")
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
