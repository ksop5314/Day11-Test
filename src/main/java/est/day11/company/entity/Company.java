package est.day11.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "COMPANY_NAME", nullable = false)
    private String name;

    @Column(name = "BUSINESS_NUMBER", nullable = false, unique = true)
    private String businessNumber;

    @Column(name = "COMPANY_ADDRESS", nullable = false, unique = true)
    private String address;

    @Builder
    public Company(String name, String businessNumber, String address) {
        this.name = name;
        this.businessNumber = businessNumber;
        this.address = address;
    }

    @OneToMany(mappedBy = "company")
    private List<ContactPerson> contactPersons = new ArrayList<>();

    public void updateCompany(String name, String businessNumber, String address) {
        this.name = name;
        this.businessNumber = businessNumber;
        this.address = address;
    }

}
