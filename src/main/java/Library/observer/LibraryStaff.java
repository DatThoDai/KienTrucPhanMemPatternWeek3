package Library.observer;

import Library.observer.Observer;

public class LibraryStaff implements Observer {
    private String name;

    public LibraryStaff(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Thông báo đến nhân viên " + name + ": " + message);
    }
}
