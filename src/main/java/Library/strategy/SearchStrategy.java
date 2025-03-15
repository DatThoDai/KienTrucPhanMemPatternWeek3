package Library.strategy;

import Library.model.Book;

import java.util.List;
public interface SearchStrategy {
    List<Book> search(List<Book> books, String keyword);
}

