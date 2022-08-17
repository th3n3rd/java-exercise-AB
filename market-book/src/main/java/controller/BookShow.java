package controller;

import dao.BookQueryDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.BookServiceImplementation;

/**
 * Servlet implementation class BookShow
 */
@WebServlet("/BookShow")
public class BookShow extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookShow() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        var bookPersistence = new BookQueryDAO();
        var bookService = new BookServiceImplementation(bookPersistence);
        var availableBooks = bookService.showBooks();

        request.setAttribute("books", availableBooks);
        request.getRequestDispatcher("/bookList.jsp").include(request, response);
    }
}
