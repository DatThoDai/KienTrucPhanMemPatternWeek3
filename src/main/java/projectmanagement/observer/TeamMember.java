package projectmanagement.observer;

public class TeamMember implements TaskObserver {
    private String name;
    private String role;
    private TaskSubject subject;

    public TeamMember(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public void update() {
        String update = (String) subject.getUpdate(this);
        if (update == null) {
            System.out.println(name + " (" + role + ") :: No new task updates");
        } else {
            System.out.println(name + " (" + role + ") :: " + update);
        }
    }

    @Override
    public void setSubject(TaskSubject subject) {
        this.subject = subject;
    }
}
