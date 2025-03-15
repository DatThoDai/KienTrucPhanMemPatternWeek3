package filesystem;

public class FileSystemTest {
    public static void main(String[] args) {
        // Tạo một số tập tin
        FileSystemComponent textFile = new File("document.txt", 100, "Đây là nội dung văn bản");
        FileSystemComponent imageFile = new File("photo.jpg", 2048, "Dữ liệu hình ảnh");
        FileSystemComponent videoFile = new File("movie.mp4", 5120, "Dữ liệu video");

        // Tạo các thư mục
        Folder documentsFolder = new Folder("Documents");
        Folder mediaFolder = new Folder("Media");
        Folder rootFolder = new Folder("Root");

        // Thêm tập tin vào thư mục
        documentsFolder.add(textFile);
        mediaFolder.add(imageFile);
        mediaFolder.add(videoFile);

        // Thêm thư mục con vào thư mục gốc
        rootFolder.add(documentsFolder);
        rootFolder.add(mediaFolder);

        // Hiển thị cấu trúc thư mục
        rootFolder.display("");

        // Hiển thị tổng kích thước
        System.out.println("\nTổng kích thước: " + rootFolder.getSize() + " bytes");

        // Tạo và thêm một thư mục con mới vào Media
        Folder videosFolder = new Folder("Videos");
        FileSystemComponent anotherVideo = new File("tutorial.mp4", 3072, "Dữ liệu video hướng dẫn");
        videosFolder.add(anotherVideo);
        mediaFolder.add(videosFolder);

        // Hiển thị cấu trúc cập nhật
        System.out.println("\n=== Sau khi cập nhật ===");
        rootFolder.display("");
        System.out.println("\nTổng kích thước mới: " + rootFolder.getSize() + " bytes");
    }
}
