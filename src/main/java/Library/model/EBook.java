package Library.model;

import Library.model.Book;

public class EBook implements Book {
    private String title;
    private String author;
    private String genre;
    private boolean available;
    private String format; // PDF, EPUB, v.v.

    public EBook(String title, String author, String genre, String format) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.format = format;
        this.available = true;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public String getType() {
        return "Sách điện tử (" + format + ")";
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
