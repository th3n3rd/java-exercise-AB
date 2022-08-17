package factories;

import dao.UserQueryDAO;
import model.User;
import services.UserServiceImplementation;
import services.UserServiceInterface;

public class UserFactory {
    public static User createUser(String userName, String userSurname, String userEmail, String userPassword) {
        return new User(userName, userSurname, userEmail, userPassword);
    }

    public static UserServiceInterface getUserService() {
        return new UserServiceImplementation(
            new UserQueryDAO()
        );
    }
}
