package Library.model;

import Library.model.Book;

public class PhysicalBook implements Book {
    private String title;
    private String author;
    private String genre;
    private boolean available;

    public PhysicalBook(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = true;
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
        return "Sách giấy";
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
