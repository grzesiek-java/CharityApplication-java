package pl.coderslab.charity.service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repo.UserRepo;

import java.util.List;


@Service
public class JpaUserService implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public JpaUserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepo.save(user);
    }

    @Override
    public User getUser(String name) {
        return userRepo.findByUsername(name).get();
    }

    @Override
    public List<User> showAll() {
        return userRepo.findAll();
    }
}
