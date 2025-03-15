package filesystem;

public interface FileSystemComponent {
    void display(String indent);
    String getName();
    int getSize();
}