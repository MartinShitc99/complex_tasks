package test.java.RatingMovie;

public class Rating<T extends Number> {
    private T grade;

    public Rating(T grade) {
        this.grade = grade;
    }

    public T getGrade() {
        return grade;
    }
}
