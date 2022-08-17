package services;

import dao.UserInterfaceDAO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import model.User;

public class UserServiceImplementation implements UserServiceInterface {
    private UserInterfaceDAO userPersistence;

    public UserServiceImplementation(UserInterfaceDAO userPersistence) {
        super();
        this.userPersistence = userPersistence;
    }

    @Override
    public User registerUser(User user) {
        /* Plain-text password initialisation. */
        var plaintextPassword = user.getUserPassword();
        try {
            /* MessageDigest instance for MD5. */
            var messageDigest = MessageDigest.getInstance("MD5");

            /* Add plain-text password bytes to digest using MD5 update() method. */
            messageDigest.update(plaintextPassword.getBytes());

            /* Convert the hash value into bytes */
            var bytes = messageDigest.digest();

            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */
            var hashedPassword = new StringBuilder();
            for (var i = 0; i < bytes.length; i++) {
                hashedPassword.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            /* Complete hashed password in hexadecimal format */
            //create the new object with the new encrypted paswword
            var usr = new User(
                user.getUsername(),
                user.getUserSurname(),
                user.getUserEmail(),
                hashedPassword.toString()
            );

            return this.userPersistence.registerUser(usr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String loginUser(String email, String password) {
        try {
            /* MessageDigest instance for MD5. */
            var messageDigest = MessageDigest.getInstance("MD5");

            /* Add plain-text password bytes to digest using MD5 update() method. */
            messageDigest.update(password.getBytes());

            /* Convert the hash value into bytes */
            var bytes = messageDigest.digest();

            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */
            var hashedPassword = new StringBuilder();
            for (var i = 0; i < bytes.length; i++) {
                hashedPassword.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            /* Complete hashed password in hexadecimal format */
            return this.userPersistence.loginUser(email, hashedPassword.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
