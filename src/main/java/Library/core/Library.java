package Library.core;

import Library.model.Book;
import Library.observer.Observer;
import Library.strategy.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private static Library instance;
    private List<Book> books;
    private List<Observer> observers;

    // Private constructor để ngăn việc tạo đối tượng từ bên ngoài
    private Library() {
        books = new ArrayList<>();
        observers = new ArrayList<>();
    }

    // Static block initialization để xử lý ngoại lệ
    static {
        try {
            instance = new Library();
        } catch (Exception e) {
            throw new RuntimeException("Có lỗi xảy ra khi khởi tạo Library");
        }
    }

    // Phương thức để lấy instance của Library
    public static Library getInstance() {
        return instance;
    }

    // Các phương thức quản lý sách
    public void addBook(Book book) {
        books.add(book);
        notifyObservers("Sách mới được thêm vào: " + book.getTitle());
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    // Các phương thức quản lý observer
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    // Tìm kiếm sách sử dụng Strategy pattern
    public List<Book> searchBooks(SearchStrategy strategy, String keyword) {
        return strategy.search(books, keyword);
    }
}
