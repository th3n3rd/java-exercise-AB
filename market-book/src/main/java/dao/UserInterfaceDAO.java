package dao;

import model.User;

public interface UserInterfaceDAO {
    User registerUser(User user);
    String loginUser(String email, String password);
}
