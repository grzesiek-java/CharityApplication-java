package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
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
}
