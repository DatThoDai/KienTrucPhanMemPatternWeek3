package Library.model;

import Library.model.Book;

public class AudioBook implements Book {
    private String title;
    private String author;
    private String genre;
    private boolean available;
    private int duration; // in minutes

    public AudioBook(String title, String author, String genre, int duration) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.duration = duration;
        this.available = true;
    }

    public int getDuration() {
        return duration;
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
        return "Sách nói (" + duration + " phút)";
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

