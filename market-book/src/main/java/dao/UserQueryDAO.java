package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import utilities.UserConnection;

public class UserQueryDAO implements UserInterfaceDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet results;

    @Override
    public User registerUser(User user) {
        connection = UserConnection.getUserConnection();
        var query = "INSERT INTO user (name,surname,email,password) VALUES(?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getUserSurname());
            preparedStatement.setString(3, user.getUserEmail());
            preparedStatement.setString(4, user.getUserPassword());

            var value = preparedStatement.executeUpdate();
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

        connection = UserConnection.getUserConnection();
        var query = "SELECT * FROM user WHERE email =? AND password =?";
        try {
            preparedStatement = connection.prepareStatement(query);
            //replace the ? with email and password details
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            results = preparedStatement.executeQuery();

            if (results.next()) {
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
