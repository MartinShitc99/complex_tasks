package test.java;

import org.junit.jupiter.api.Test;
import practice_13.User;
import practice_13.UserValidator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UserValidatorTest {

    @Test
    public void validUserTest() {
        UserValidator validator = new UserValidator();
        validator.setValidationEnabled(true);

        User user = new User("Martin", 27, "shitcz52@gmail.com");
        assertDoesNotThrow(() -> validator.validate(user));
    }
}
