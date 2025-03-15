package filesystem;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        components.add(component);
    }

    public void remove(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Thư mục: " + name + " (Kích thước: " + getSize() + " bytes)");

        // Hiển thị tất cả các thành phần con với thụt lề để thể hiện cấu trúc cây
        for (FileSystemComponent component : components) {
            component.display(indent + "   ");
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        // Tính tổng kích thước của tất cả các thành phần con
        int totalSize = 0;
        for (FileSystemComponent component : components) {
            totalSize += component.getSize();
        }
        return totalSize;
    }

    public List<FileSystemComponent> getComponents() {
        return components;
    }
}
