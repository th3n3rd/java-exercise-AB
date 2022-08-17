package services;

import model.User;

public interface UserServiceInterface {
    User registerUser(User user);
    public String loginUser(String eamil, String password);
}
