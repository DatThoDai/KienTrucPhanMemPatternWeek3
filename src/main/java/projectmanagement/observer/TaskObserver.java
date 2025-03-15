package projectmanagement.observer;

public interface TaskObserver {
    // Method to update the observer, used by subject
    void update();

    // Attach with subject to observe
    void setSubject(TaskSubject subject);
}
