package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class MainPageController {

    @GetMapping("/main")
    public String mainGet(Principal principal, Model model){
        model.addAttribute("user", principal.getName());
        return "main";
    }
}
