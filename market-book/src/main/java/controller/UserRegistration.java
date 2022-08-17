package controller;

import dao.UserInterfaceDAO;
import factories.UserFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import services.UserServiceInterface;


@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserRegistration() {
        super();
    }

    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        var name = request.getParameter("name");
        var surname = request.getParameter("surname");
        var email = request.getParameter("email");
        var password = request.getParameter("password");
        //use of factory pattern
        var newUser = UserFactory.getUser(name, surname, email, password);

        var userPersistence = UserFactory.getUserDAO();
        var userService = UserFactory.getUserServiceImplementation(userPersistence);
        var registeredUser = userService.registerUser(newUser);

        if (registeredUser != null) {
            response.sendRedirect("Success.jsp");
        } else {
            response.sendRedirect("Fail.jsp");
        }
    }
}
