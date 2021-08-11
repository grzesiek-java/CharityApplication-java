package pl.coderslab.charity.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repo.DonationRepo;

@Service
public class JpaDonationService implements DonationService{

    private DonationRepo donationRepo;

    public JpaDonationService(DonationRepo donationRepo) {
        this.donationRepo = donationRepo;
    }


    @Override
    public long showNumber() {
        return donationRepo.count();
    }

    @Override
    public Long showNumberOfBags(){
        return donationRepo.numberOfBags();
    }

    @Override
    public void addDonation(Donation donation) {
        donationRepo.save(donation);
    }

}
