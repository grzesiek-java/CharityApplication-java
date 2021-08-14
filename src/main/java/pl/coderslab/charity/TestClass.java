package pl.coderslab.charity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repo.UserRepo;

@Configuration
public class TestClass {

    private UserRepo userRepo;

    public TestClass(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;


//        User user = new User();
//        user.setUsername("zzz");
//        user.setPassword(passwordEncoder.encode("zzz"));
//        user.setRole("ROLE_ADMIN");
//        userRepo.save(user);
    }

}
