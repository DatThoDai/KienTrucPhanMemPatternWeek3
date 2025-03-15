package Library;

import Library.core.Library;
import Library.decorator.Borrowing;
import Library.decorator.ExtendedBorrowing;
import Library.decorator.PriorityBorrowing;
import Library.decorator.SpecialEditionBorrowing;
import Library.factory.BookFactory;
import Library.model.Book;
import Library.observer.LibraryStaff;
import Library.observer.Member;
import Library.observer.Observer;
import Library.strategy.AuthorSearchStrategy;
import Library.strategy.GenreSearchStrategy;
import Library.strategy.TitleSearchStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = Library.getInstance();

        Observer staff1 = new LibraryStaff("Nguyễn Văn A");
        Observer staff2 = new LibraryStaff("Trần Thị B");
        Observer member1 = new Member("Lê Văn C", "levanc@gmail.com");
        Observer member2 = new Member("Phạm Thị D", "phamthid@gmail.com");

        library.registerObserver(staff1);
        library.registerObserver(staff2);
        library.registerObserver(member1);
        library.registerObserver(member2);

        // Thêm sách với Factory Method Pattern
        Book book1 = BookFactory.createBook("physical", "Đắc Nhân Tâm", "Dale Carnegie", "Tâm lý");
        Book book2 = BookFactory.createBook("ebook", "Dạy Con Làm Giàu", "Robert Kiyosaki", "Tài chính", "PDF");
        Book book3 = BookFactory.createBook("audiobook", "Nhà Giả Kim", "Paulo Coelho", "Tiểu thuyết", 180);
        Book book4 = BookFactory.createBook("physical", "Tôi Tài Giỏi, Bạn Cũng Thế", "Adam Khoo", "Kỹ năng sống");
        Book book5 = BookFactory.createBook("ebook", "Đọc Vị Bất Kỳ Ai", "David J. Lieberman", "Tâm lý", "EPUB");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        // Tìm kiếm sách với Strategy Pattern
        System.out.println("\n--- Tìm kiếm sách theo tác giả 'Dale' ---");
        List<Book> authorResults = library.searchBooks(new AuthorSearchStrategy(), "Dale");
        for (Book book : authorResults) {
            System.out.println(book.getTitle() + " - " + book.getAuthor() + " (" + book.getType() + ")");
        }

        System.out.println("\n--- Tìm kiếm sách theo thể loại 'Tâm lý' ---");
        List<Book> genreResults = library.searchBooks(new GenreSearchStrategy(), "Tâm lý");
        for (Book book : genreResults) {
            System.out.println(book.getTitle() + " - " + book.getAuthor() + " (" + book.getType() + ")");
        }

        System.out.println("\n--- Tìm kiếm sách theo tên 'Nhà' ---");
        List<Book> titleResults = library.searchBooks(new TitleSearchStrategy(), "Nhà");
        for (Book book : titleResults) {
            System.out.println(book.getTitle() + " - " + book.getAuthor() + " (" + book.getType() + ")");
        }

        // Mượn sách với Decorator Pattern
        System.out.println("\n--- Mượn sách cơ bản ---");
        Borrowing borrowing1 = new Borrowing(book1, "Trần Văn X");
        System.out.println(borrowing1.getDetails());

        System.out.println("\n--- Mượn sách với gia hạn thêm ---");
        Borrowing extendedBorrowing = new ExtendedBorrowing(
                new Borrowing(book2, "Lê Thị Y"),
                7
        );
        System.out.println(extendedBorrowing.getDetails());

        System.out.println("\n--- Mượn sách phiên bản đặc biệt ---");
        Borrowing specialBorrowing = new SpecialEditionBorrowing(
                new Borrowing(book3, "Phạm Văn Z"),
                "Bản dịch tiếng Việt có chú thích"
        );
        System.out.println(specialBorrowing.getDetails());

        System.out.println("\n--- Mượn sách kết hợp nhiều tính năng ---");
        Borrowing complexBorrowing = new PriorityBorrowing(
                new ExtendedBorrowing(
                        new SpecialEditionBorrowing(
                                new Borrowing(book4, "Hoàng Thị K"),
                                "Bản có chữ nổi cho người khiếm thị"
                        ),
                        14
                ),
                "Cao"
        );
        System.out.println(complexBorrowing.getDetails());

        // Thông báo sách hết hạn
        library.notifyObservers("Sách '" + book5.getTitle() + "' đã hết hạn mượn");
    }
}
