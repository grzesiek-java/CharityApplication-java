package pl.coderslab.charity.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;


@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/register")
    public String registerGet(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping(value = "/register")
    public String registerPost(User user) {
        System.out.println(user);
        userService.addUser(user);
        return "redirect:/login";
    }

}
