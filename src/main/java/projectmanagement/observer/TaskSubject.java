package projectmanagement.observer;

public interface TaskSubject {
    // Methods to register and unregister observers
    void register(TaskObserver observer);
    void unregister(TaskObserver observer);

    // Method to notify observers of change
    void notifyObservers();

    // Method to get updates from subject
    Object getUpdate(TaskObserver observer);
}
