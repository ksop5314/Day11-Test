package est.day11.company.repository;

import est.day11.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

    Company findByBusinessNumber(String businessNumber);

}
