package pl.coderslab.charity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
