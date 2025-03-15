package Library.strategy;

import Library.model.Book;
import Library.strategy.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class GenreSearchStrategy implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books, String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
}
