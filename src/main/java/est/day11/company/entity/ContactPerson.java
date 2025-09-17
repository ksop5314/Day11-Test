package est.day11.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContactPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CP_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "CP_NAME", nullable = false)
    private String name;

    @Column(name = "CP_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "CP_PHONE", nullable = false, unique = true)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @Builder
    public ContactPerson(String name, String email, String phone, Company company) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.company = company;
    }

}
