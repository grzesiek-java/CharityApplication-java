package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Donation;

public interface DonationService {
    long showNumber();

    Long showNumberOfBags();

    void addDonation(Donation donation);
}
