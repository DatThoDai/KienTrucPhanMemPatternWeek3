package projectmanagement.observer;

import java.util.ArrayList;
import java.util.List;

public class Task implements TaskSubject {
    private List<TaskObserver> observers;
    private String taskId;
    private String title;
    private String status;
    private boolean changed;
    private final Object MUTEX = new Object();

    public Task(String id, String title) {
        this.taskId = id;
        this.title = title;
        this.status = "Created";
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(TaskObserver observer) {
        if (observer == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if (!observers.contains(observer)) observers.add(observer);
        }
    }

    @Override
    public void unregister(TaskObserver observer) {
        synchronized (MUTEX) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        List<TaskObserver> observersLocal = null;

        // Synchronization is used to make sure any observer registered after status change is not notified
        synchronized (MUTEX) {
            if (!changed) return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;
        }

        for (TaskObserver observer : observersLocal) {
            observer.update();
        }
    }

    @Override
    public Object getUpdate(TaskObserver observer) {
        return "Task #" + this.taskId + " (" + this.title + ") status changed to: " + this.status;
    }

    // Method to update task status
    public void updateStatus(String newStatus) {
        System.out.println("Task #" + this.taskId + " (" + this.title + ") status changed from " +
                this.status + " to " + newStatus);
        this.status = newStatus;
        this.changed = true;
        notifyObservers();
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }
}