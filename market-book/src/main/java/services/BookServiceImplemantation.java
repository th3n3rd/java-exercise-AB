package services;

import dao.BookInterfaceDAO;
import java.util.ArrayList;
import model.Book;

public class BookServiceImplemantation implements BookServiceInterface {
    BookInterfaceDAO bookDao;

    public BookServiceImplemantation(BookInterfaceDAO bookDao) {
        super();
        this.bookDao = bookDao;
    }

    @Override
    public ArrayList<Book> showBooks() {
        return this.bookDao.showBooks();
    }
}


