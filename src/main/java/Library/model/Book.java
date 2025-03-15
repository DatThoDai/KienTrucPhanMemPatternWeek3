package Library.model;

public interface Book {
    String getTitle();
    String getAuthor();
    String getGenre();
    String getType();
    boolean isAvailable();
    void setAvailable(boolean available);
}
