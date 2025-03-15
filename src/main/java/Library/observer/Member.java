package Library.observer;

import Library.observer.Observer;

public class Member implements Observer {
    private String name;
    private String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Thông báo đến thành viên " + name + " (" + email + "): " + message);
    }
}
