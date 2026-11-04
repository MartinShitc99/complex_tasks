package test.java;

import org.junit.jupiter.api.Test;
import test.java.StudentGrade.GradeService;
import test.java.StudentGrade.InvalidGradeException;
import test.java.StudentGrade.StudentGrade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentGradeTest {
    GradeService service = new GradeService();
    @Test
    public void TestStudentGrade() {
        StudentGrade student = new StudentGrade<>("Ilya", "Math", 10);
        StudentGrade student1 = new StudentGrade<>("Ilya", "Math", 8);


        service.addGrade(student);
        service.addGrade(student1);

        double avg = service.calculateAverage("Math");
        assertEquals(9, avg);
    }

    @Test
    public void testNegativeGradeThrowException() {
        StudentGrade<Integer> studentGrade = new StudentGrade<>("Ilya", "Math", -5);

        assertThrows(InvalidGradeException.class, () -> {
            service.addGrade(studentGrade);
        });
    }
}
