package est.day11.company.repository;

import est.day11.company.dto.ContactPersonResponse;
import est.day11.company.entity.ContactPerson;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPerson, Long> {

}
