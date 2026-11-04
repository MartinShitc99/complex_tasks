package test.java.TaskManager;

import java.time.LocalDate;

public class Task<T> {
    private T id;
    private String status;
    private LocalDate date;
    private String priority;

    public Task(String priority, LocalDate date, String status, T id) {
        this.priority = priority;
        this.date = date;
        this.status = status;
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPriority() {
        return priority;
    }
}
