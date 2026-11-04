package test.java.EntityManager;

public class Entity {
    private String name;
    private int age;
    private boolean isActive;

    public Entity(String name, int age, boolean isActive) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return isActive;
    }
}
