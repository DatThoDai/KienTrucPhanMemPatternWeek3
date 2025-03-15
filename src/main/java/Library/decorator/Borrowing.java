package Library.decorator;

import Library.model.Book;

import java.time.LocalDate;

public class Borrowing {
    protected Book book;
    protected LocalDate borrowDate;
    protected LocalDate dueDate;
    protected String borrower;

    public Borrowing(Book book, String borrower) {
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(14); // Mặc định mượn 14 ngày
        book.setAvailable(false);
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getBorrower() {
        return borrower;
    }

    public String getDetails() {
        return "Sách: " + book.getTitle() +
                "\nNgười mượn: " + borrower +
                "\nNgày mượn: " + borrowDate +
                "\nHạn trả: " + dueDate;
    }
}
