package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.*;

import javax.mail.MessagingException;
import java.security.Principal;
import java.util.List;

@Controller
public class DonationFormController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final MailService mailService;
    private final UserService userService;

    public DonationFormController(InstitutionService institutionService, DonationService donationService, CategoryService categoryService, MailService mailService, UserService userService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.mailService = mailService;
        this.userService = userService;
    }

    @GetMapping(value = "/form")
    public String formGet(Model model){
        List<Institution> institutions = institutionService.showAll();
        List<Category> categories = categoryService.showAll();
        Donation donation = new Donation();
        model.addAttribute("institutions",institutions);
        model.addAttribute("categories",categories);
        model.addAttribute("donation", donation);
        return "form";
    }
    @PostMapping(value = "/form")
    public String formPost(Donation donation,Principal principal) {
        User user = userService.getUser(principal.getName());
        donation.setUser(user);
        System.out.println(donation);
        donationService.addDonation(donation);
        sendConfirmMail(donation);
    return "redirect:/formConfirm";
    }

    private void sendConfirmMail(Donation donation) {

        String message = "Podsumowanie przekazania nr." + donation.getId() + ":\n" +
                "\nNazwa fundacji: " + donation.getInstitution().getName() +
                "\nIlość worków: " + donation.getQuantity() +
                "\nAdres odbioru worków: " + donation.getZipCode() +" "+ donation.getCity() +" ul."+ donation.getStreet() +
                "\nData odbioru: " + donation.getPickUpDate() +
                "\nGodzina odbioru: " + donation.getPickUpTime();

        try {
            mailService.sendMail(donation.getUser().getUsername(),"donation",message,false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/formConfirm")
    public String formConfirm() {
        return "form-confirm";
    }

}
