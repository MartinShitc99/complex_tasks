package test.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.java.EntityManager.EntityManager;
import test.java.EntityManager.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EntityManagerTest {
    /**
     * Тест кейсы:
     * Добавление элементов:
     *            добавить 1 элемент в пустой менеджер
     *            добавить 1 элемент в НЕпустой менеджер
     *            добавить 1 элемент несколькими потоками (проверка интеграции)
     *
     */


    @Test
    public void addEntityTest() {
        EntityManager<Student> manager = new EntityManager<>();
        Student expectedStudent = new Student("Коля", 17, true);

        int initialSize = manager.getAll().size();

        manager.add(expectedStudent);

        /**
         * Добавить элемент
         * ожидание: он содержится в финальном списке
         * ожидание: то, что было добавлено, равно тому что мы передали
         * ожидание: добавлен 1 элемент
         */

        Assertions.assertTrue(manager.getAll().contains(expectedStudent));

        Student actualStudent = manager.getAll().getFirst();

        assertEquals(expectedStudent, actualStudent);

        Assertions.assertEquals(expectedStudent.getName(), actualStudent.getName());
        Assertions.assertEquals(expectedStudent.getAge(), actualStudent.getAge());
        Assertions.assertEquals(expectedStudent.isActive(), actualStudent.isActive());

        Assertions.assertEquals(initialSize + 1, manager.getAll().size());
    }
}
