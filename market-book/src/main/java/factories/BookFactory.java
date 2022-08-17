package factories;

import dao.BookQueryDAO;
import services.BookServiceImplementation;
import services.BookServiceInterface;

public class BookFactory {
    public static BookServiceInterface getBookService() {
        return new BookServiceImplementation(
            new BookQueryDAO()
        );
    }
}
