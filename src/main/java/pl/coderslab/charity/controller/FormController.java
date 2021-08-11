package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
public class FormController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final CategoryService categoryService;

    public FormController(InstitutionService institutionService, DonationService donationService, CategoryService categoryService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.categoryService = categoryService;
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
    public String formPost(Donation donation) {
        System.out.println(donation);
        donationService.addDonation(donation);
    return "redirect:/formConfirm";
    }

    @GetMapping(value = "/formConfirm")
    public String formConfirm() {
        return "form-confirm";
    }

}
