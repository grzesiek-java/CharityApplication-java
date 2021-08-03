package pl.coderslab.charity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.Donation;

public interface DonationRepo extends JpaRepository<Donation, Long> {
}
