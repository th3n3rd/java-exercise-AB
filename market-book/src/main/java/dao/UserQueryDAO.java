package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import utilities.UserConnection;

public class UserQueryDAO implements UserInterfaceDAO {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet res;

    @Override
    public User registerUser(User user) {
        con = UserConnection.getUserConnection();
        String query = "INSERT INTO user (name,surname,email,password) VALUES(?,?,?,?)";

        try {
            pst = con.prepareStatement(query);

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getUserSurname());
            pst.setString(3, user.getUserEmail());
            pst.setString(4, user.getUserPassword());

            int value = pst.executeUpdate();
            System.out.println(user);
            System.out.println(value);

            if (value > 0) {
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String loginUser(String email, String password) {
        String loginStatus = null;

        con = UserConnection.getUserConnection();
        String query = "SELECT * FROM user WHERE email =? AND password =?";
        try {
            pst = con.prepareStatement(query);
            //replace the ? with email and password details
            pst.setString(1, email);
            pst.setString(2, password);

            res = pst.executeQuery();

            if (res.next()) {
                loginStatus = "success";
            } else {
                loginStatus = "failure";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginStatus;
    }
}
