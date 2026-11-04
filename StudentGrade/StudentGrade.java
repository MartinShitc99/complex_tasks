package test.java.StudentGrade;

public class StudentGrade<T extends Number> {
    private String name;
    private String item;
    private T score;

    public StudentGrade(String name, String item, T score) {
        this.name = name;
        this.item = item;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getItem() {
        return item;
    }

    public T getScore() {
        return score;
    }
}
