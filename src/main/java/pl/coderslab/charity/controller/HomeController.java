package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }


    @GetMapping("/")
    public String homeAction(Model model){
        List<Institution> institutions = institutionService.showAll();
        Long numberOfDonations = donationService.showNumber();
        Long numberOfBags = donationService.showNumberOfBags();
        model.addAttribute("institutions",institutions);
        model.addAttribute("numberOfDonations",numberOfDonations);
        model.addAttribute("numberOfBags",numberOfBags);
        return "start";
    }

    @GetMapping("/test")
    public String testAction(){
        return "test";
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }

}
