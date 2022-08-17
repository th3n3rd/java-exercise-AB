package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import utilities.UserConnection;

public class UserQueryDAO implements UserInterfaceDAO {

    @Override
    public User registerUser(User user) {
        var query = "INSERT INTO user (name,surname,email,password) VALUES(?,?,?,?)";

        try (
            var connection = UserConnection.getUserConnection();
            var preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getUserSurname());
            preparedStatement.setString(3, user.getUserEmail());
            preparedStatement.setString(4, user.getUserPassword());

            var value = preparedStatement.executeUpdate();
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
        try (
            var connection = UserConnection.getUserConnection();
            var preparedStatement = prepareLoginQuery(email, password, connection);
            var results = preparedStatement.executeQuery();
        ) {
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

    private static PreparedStatement prepareLoginQuery(
        String email,
        String password,
        Connection connection
    ) throws SQLException {
        var query = "SELECT * FROM user WHERE email =? AND password =?";
        var preparedStatement = connection.prepareStatement(query);
        //replace the ? with email and password details
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        return preparedStatement;
    }
}
