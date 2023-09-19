package pl.camp.it.book.store.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.camp.it.book.store.exceptions.UserValidationException;
import pl.camp.it.book.store.model.User;

class UserValidatorTest {

    @Test
    public void notUpperCaseFirstLetterNameTest() {
        String name = "janusz";

        Assertions.assertThrows(UserValidationException.class,
                () -> UserValidator.validateName(name));
    }

    @Test
    public void correctNameTest() {
        String name = "Janusz";

        UserValidator.validateName(name);
    }

    @Test
    public void correctSurnameTest() {
        String surname = "Kowalski";

        UserValidator.validateSurname(surname);
    }

    @Test
    public void surnameWithNumberTest() {
        String surname = "Kowalski123";

        Assertions.assertThrows(UserValidationException.class,
                () -> UserValidator.validateSurname(surname));
    }

    @Test
    public void correctLoginTest() {
        String login = "janusz";

        UserValidator.validateLogin(login);
    }

    @Test
    public void tooShortLoginTest() {
        String login = "abc";

        Assertions.assertThrows(UserValidationException.class,
                () -> UserValidator.validateLogin(login));
    }

    @Test
    public void correctPasswordTest() {
        String pass = "janusz123";

        UserValidator.validatePassword(pass);
    }

    @Test
    public void tooShortPasswordTest() {
        String pass = "abc";

        Assertions.assertThrows(UserValidationException.class,
                () -> UserValidator.validatePassword(pass));
    }

    @Test
    public void correctEmailTest() {
        String email = "mateusz@gmail.com";

        UserValidator.validateEmail(email);
    }

    @Test
    public void emailWithoutAtTest() {
        String email = "mateusz.gmail.com";

        Assertions.assertThrows(UserValidationException.class,
                () -> UserValidator.validateEmail(email));
    }

    @Test
    public void passwordsEqualTest() {
        String pass1 = "janusz123";
        String pass2 = "janusz123";

        UserValidator.validatePasswordsEquality(pass1, pass2);
    }

    @Test
    public void passwordsNotEqualTest() {
        String pass1 = "janusz123";
        String pass2 = "janusz12";

        Assertions.assertThrows(UserValidationException.class,
                () -> UserValidator.validatePasswordsEquality(pass1, pass2));
    }

    @Test
    public void correctUserTest() {
        User user = new User(23455, "janusz",
                "janusz123",
                "Janusz", "Kowalski", "janusz@gmail.com",
                User.Role.ADMIN);

        UserValidator.validateUser(user);
    }

    @Test
    public void userWithIncorrectEmailTest() {
        User user = new User(23455, "janusz",
                "janusz123",
                "Janusz", "Kowalski", "janusz.gmail.com",
                User.Role.ADMIN);

        Assertions.assertThrows(UserValidationException.class,
                () -> UserValidator.validateUser(user));
    }
}