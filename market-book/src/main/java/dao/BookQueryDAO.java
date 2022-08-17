package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Book;
import utilities.BookConnection;

public class BookQueryDAO implements BookInterfaceDAO, Serializable {

    private static final long serialVersionUID = 1L;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet results;
    private ArrayList<Book> books;

    public ArrayList<Book> listBooks() {
        connection = BookConnection.getBookConnection();
        var query = "SELECT * FROM book";

        books = new ArrayList<Book>();

        try {
            preparedStatement = connection.prepareStatement(query);

            results = preparedStatement.executeQuery();

            while (results.next()) {
                var book = new Book();
                book.setBookId(results.getInt("id"));
                book.setBookTitle(results.getString("title"));
                book.setBookAuthor(results.getString("author"));
                book.setBookYear(results.getInt("year"));
                book.setBookCost(results.getDouble("cost"));

                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            results.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
