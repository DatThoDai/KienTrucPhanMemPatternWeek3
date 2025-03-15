package filesystem;

public class File implements FileSystemComponent {
    private String name;
    private int size;
    private String data;

    public File(String name, int size, String data) {
        this.name = name;
        this.size = size;
        this.data = data;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "File: " + name + " (Kích thước: " + size + " bytes)");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    public String getData() {
        return data;
    }
}
