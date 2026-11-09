package test.java.TaskManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService<T> {
    List<Task<T>> tasks = new ArrayList<>();

    public synchronized void addTask(Task<T> task) {
        for (Task<T> existingTask : tasks) {
            if (existingTask.getId().equals(task.getId())) {
                return;
            }
        }
        tasks.add(task);
    }

    public synchronized void removeTask(T id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }

    public List<Task<T>> filterTasks(String status, String priority) {
        return tasks.stream()
                .filter(task -> task.getPriority().equals(priority) && task.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public List<Task<T>> sortByDate() {
        return tasks.stream().sorted(Comparator.comparing(Task::getDate))
                .collect(Collectors.toList());
    }
}
