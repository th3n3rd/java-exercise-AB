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
    private Connection con;
    private PreparedStatement pst;
    private ResultSet res;
    private ArrayList<Book> list;

    public ArrayList<Book> showBooks() {
        con = BookConnection.getBookConnection();
        String query = "SELECT * FROM book";

        list = new ArrayList<Book>();

        try {
            pst = con.prepareStatement(query);

            res = pst.executeQuery();

            while (res.next()) {
                Book book = new Book();
                book.setBookId(res.getInt("id"));
                book.setBookTitle(res.getString("title"));
                book.setBookAuthor(res.getString("author"));
                book.setBookYear(res.getInt("year"));
                book.setBookCost(res.getDouble("cost"));

                list.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            res.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
