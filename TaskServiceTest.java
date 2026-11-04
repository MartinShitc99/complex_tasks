package test.java;

import org.junit.jupiter.api.Test;
import test.java.TaskManager.Task;
import test.java.TaskManager.TaskService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskServiceTest {
    TaskService<Integer> service = new TaskService<>();
    @Test
    public void TaskService() {
        Task<Integer> task1 = new Task<>("High", LocalDate.now(), "New", 1);
        Task<Integer> task2 = new Task<>("High", LocalDate.now(), "Done", 2);

        service.addTask(task1);
        service.addTask(task2);

        List<Task<Integer>> result = service.filterTasks("Done", "High");

        assertEquals(1, result.size());
        assertEquals(2, result.get(0).getId());
    }

    @Test
    public void testSortByDate() {
        Task<Integer> task1 = new Task<>("High", LocalDate.now(), "New", 1);
        Task<Integer> task2 = new Task<>("High", LocalDate.now().minusDays(1), "Done", 2);
        service.addTask(task1);
        service.addTask(task2);
        List<Task<Integer>> sorted = service.sortByDate();
        assertEquals(2, sorted.get(0).getId());
    }

    @Test
    public void testRemoveTask() {
        Task<Integer> task1 = new Task<>("High", LocalDate.now(), "New", 1);
        Task<Integer> task2 = new Task<>("High", LocalDate.now().minusDays(1), "Done", 2);

        service.addTask(task1);
        service.removeTask(1);
        assertEquals(0, service.sortByDate().size());
    }
}
