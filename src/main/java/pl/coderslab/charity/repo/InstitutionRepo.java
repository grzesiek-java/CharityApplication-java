package pl.coderslab.charity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.Institution;

@Repository
public interface InstitutionRepo extends JpaRepository<Institution, Long> {
}
