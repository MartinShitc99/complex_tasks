package test.java.StudentGrade;

import java.util.ArrayList;
import java.util.List;

public class GradeService<T extends Number> {
    private List<StudentGrade<T>> grades = new ArrayList<>();

    public synchronized void addGrade(StudentGrade<T> grade) {
        if (grade.getScore().doubleValue() < 0) {
            throw new InvalidGradeException("Оценка не может быть отрицательной!");
        }
        grades.add(grade);
    }

    public synchronized double calculateAverage(String item) {
        double sum = 0;
        int count = 0;
        for (StudentGrade<T> grade : grades) {
            if (grade.getItem().equals(item)) {
                sum += grade.getScore().doubleValue();
                count++;

            }
        }
        if (count == 0) {
            return 0.0;
        }
        return sum / count;
    }

}
