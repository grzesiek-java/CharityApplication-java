package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.*;

import java.security.Principal;
import java.util.List;

@Controller
public class AdminPagesController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final UserService userService;

    public AdminPagesController(InstitutionService institutionService, DonationService donationService, CategoryService categoryService, UserService userService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String adminPanelGet(Model model, Principal principal){
        model.addAttribute("user",userService.getUser(principal.getName()));
        return "admin/admin";
    }
    @GetMapping(value = "/institutions")
    public  String institutionsGet(Model model,Principal principal){
        List<Institution> institutionList = institutionService.showAll();
        model.addAttribute("user",userService.getUser(principal.getName()));
        model.addAttribute("institutions",institutionList);
        return "admin/institutions";
    }

    @GetMapping(value = "/categories")
    public  String categoriesGet(Model model,Principal principal){
        List<Category> categoryList = categoryService.showAll();
        model.addAttribute("user",userService.getUser(principal.getName()));
        model.addAttribute("categories",categoryList);
        return "admin/categories";
    }

    @GetMapping(value = "/users")
    public  String usersGet(Model model,Principal principal){
        List<User> userList = userService.showAll();
        model.addAttribute("user",userService.getUser(principal.getName()));
        model.addAttribute("users",userList);
        return "admin/users";
    }

//    @ModelAttribute("user")
//    Principal principal;
//    User getUser(){
//        return userService.getUser(principal.getName());
//    }


}
