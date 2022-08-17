package model;

public class Book {
    Integer bookId;
    String bookGenre;
    String bookTitle;
    String bookAuthor;
    Integer bookYear;
    Double bookCost;

    //Constructor
    public Book() {
    }

    public Book(String bookTitle, String bookAuthor, Integer bookYear, Double bookCost) {
        super();
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
        this.bookCost = bookCost;
    }

    public Book(Integer bookId, String bookTitle, String bookAuthor, Integer bookYear, Double bookCost) {
        super();
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
        this.bookCost = bookCost;
    }

    //Getters
    public Integer getBookId() {
        return bookId;
    }

    //Setters
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getBookYear() {
        return bookYear;
    }

    public void setBookYear(Integer bookYear) {
        this.bookYear = bookYear;
    }

    public Double getBookCost() {
        return bookCost;
    }

    public void setBookCost(Double bookCost) {
        this.bookCost = bookCost;
    }

    //ToString
    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", bookYear=" + bookYear + ", bookCost=" + bookCost + "]";
    }
}
