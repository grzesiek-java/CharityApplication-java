package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import java.security.Principal;

@Controller
public class MainPageController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final UserService userService;

    public MainPageController(InstitutionService institutionService, DonationService donationService, CategoryService categoryService, UserService userService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping("/main")
    public String mainGet(Principal principal, Model model){
        model.addAttribute("user",userService.getUser(principal.getName()));
        return "main";
    }
    @GetMapping("/userUpdate")
    public String userUpdateGet(Principal principal, Model model){
        model.addAttribute("user",userService.getUser(principal.getName()));
        return "user/userUpdate";
    }
    @PostMapping("/userUpdate")
    public String userUpdatePost(User user){
        return "redirect:/main";
    }

}
