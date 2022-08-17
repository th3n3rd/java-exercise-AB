package services;

import dao.BookInterfaceDAO;
import java.util.ArrayList;
import model.Book;

public class BookServiceImplementation implements BookServiceInterface {
    BookInterfaceDAO bookPersistence;

    public BookServiceImplementation(BookInterfaceDAO bookPersistence) {
        super();
        this.bookPersistence = bookPersistence;
    }

    @Override
    public ArrayList<Book> listBooks() {
        return this.bookPersistence.listBooks();
    }
}


