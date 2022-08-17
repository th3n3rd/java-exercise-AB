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
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //use of factory pattern
        User us = UserFactory.getUser(name, surname, email, password);

        UserInterfaceDAO dao = UserFactory.getUserDAO();

        UserServiceInterface usi = UserFactory.getUserServiceImplementation(dao);

        User registeredUser = usi.registerUser(us);

        if (registeredUser != null) {
            response.sendRedirect("Success.jsp");
        } else {
            response.sendRedirect("Fail.jsp");
        }
    }
}
