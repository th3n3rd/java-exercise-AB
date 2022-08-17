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

    public ArrayList<Book> listBooks() {
        var query = "SELECT * FROM book";
        var books = new ArrayList<Book>();

        try (
            var connection = BookConnection.getBookConnection();
            var preparedStatement = connection.prepareStatement(query);
            var results = preparedStatement.executeQuery();
        ) {
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

        return books;
    }
}
