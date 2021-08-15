package pl.coderslab.charity.service;

import pl.coderslab.charity.model.User;

public interface UserService {
    void addUser(User user);

    User getUser(String name);
}
