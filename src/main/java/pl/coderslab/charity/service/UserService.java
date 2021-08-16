package pl.coderslab.charity.service;

import pl.coderslab.charity.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    User getUser(String name);

    List<User> showAll();
}
