package pl.coderslab.charity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.Institution;

public interface InstitutionRepo extends JpaRepository<Institution, Long> {
}
