package services;

import model.User;

public interface UserServiceInterface {
    User registerUser(User user);
    String loginUser(String email, String password);
}
