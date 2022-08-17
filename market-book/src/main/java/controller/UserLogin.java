package controller;

import dao.UserInterfaceDAO;
import dao.UserQueryDAO;
import factories.UserFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.UserServiceImplementation;
import services.UserServiceInterface;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
    }

    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        var email = request.getParameter("email");
        var password = request.getParameter("password");

        var userService = UserFactory.getUserService();
        var loginStatus = userService.loginUser(email, password);

        if (loginStatus.equals("success")) {
            response.sendRedirect("Success.jsp");
        } else {
            response.sendRedirect("Fail.jsp");
        }
    }
}
