package practice_13;

public class UserValidator {
    private boolean validationEnabled;

    public void setValidationEnabled(boolean validationEnabled) {
        this.validationEnabled = validationEnabled;
    }

    public void validate(User user) {

        String name = user.getName();
        String mail = user.getMail();

        if (!validationEnabled) {
            return;
        }
        if (user.getAge() < 18 || user.getAge() > 100) {
            throw new InvalidUserException("Возраст должен быть от 18 до 100 лет");
        }
        if (user.getName() == null || user.getName().isEmpty() || !Character.isUpperCase(name.charAt(0))) {
            throw new InvalidUserException("Имя должно быть не пустым и начинаться с заглавной буквы");
        }
        if (user.getMail() == null || !mail.contains("@") || !mail.contains(".")) {
            throw new InvalidUserException("Некорректный формат почты");
        }
    }
}
