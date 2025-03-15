package Library.factory;

import Library.model.AudioBook;
import Library.model.Book;
import Library.model.EBook;
import Library.model.PhysicalBook;
public class BookFactory {
    public static Book createBook(String type, String title, String author, String genre, Object... additionalParams) {
        switch (type.toLowerCase()) {
            case "physical":
                return new PhysicalBook(title, author, genre);
            case "ebook":
                String format = (additionalParams.length > 0) ? (String) additionalParams[0] : "PDF";
                return new EBook(title, author, genre, format);
            case "audiobook":
                int duration = (additionalParams.length > 0) ? (int) additionalParams[0] : 60;
                return new AudioBook(title, author, genre, duration);
            default:
                throw new IllegalArgumentException("Loại sách không hợp lệ: " + type);
        }
    }
}
