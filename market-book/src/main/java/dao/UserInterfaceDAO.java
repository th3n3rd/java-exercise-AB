package dao;

import model.User;

public interface UserInterfaceDAO {
    User registerUser(User user);
    public String loginUser(String eamil, String password);
}
