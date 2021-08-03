package pl.coderslab.charity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Donation;

public interface DonationRepo extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT SUM (quantity) FROM Donation ")
    Long numberOfBags();
}
