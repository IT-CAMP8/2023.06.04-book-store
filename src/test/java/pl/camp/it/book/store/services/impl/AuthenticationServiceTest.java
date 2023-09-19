package pl.camp.it.book.store.services.impl;

import jakarta.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.camp.it.book.store.exceptions.LoginAlreadyExistException;
import pl.camp.it.book.store.model.User;
import pl.camp.it.book.store.services.IAuthenticationService;
import pl.camp.it.book.store.session.SessionData;

import java.util.Optional;

@WebAppConfiguration
class AuthenticationServiceTest extends ServiceGenericTest {

    @Autowired
    IAuthenticationService authenticationService;

    @Resource
    SessionData sessionData;

    @Test
    public void correctAuthenticationTest() {
        String login = "janusz";
        String password = "janusz123";
        User user = generateFakeUser(DigestUtils.md5Hex(password));
        Mockito.when(this.userRepository.getByLogin(Mockito.any()))
                .thenReturn(Optional.of(user));

        this.authenticationService.authenticate(login, password);

        Assertions.assertNotNull(this.sessionData.getUser());
        Assertions.assertNull(this.sessionData.getUser().getPassword());
        Assertions.assertSame(user, this.sessionData.getUser());
        Mockito.verify(this.userRepository, Mockito.times(1))
                .getByLogin(Mockito.any());
    }

    @Test
    public void incorrectPasswordAuthenticationTest() {
        String login = "janusz";
        String password = "zlehaslo";
        User user = generateFakeUser(DigestUtils.md5Hex("dobrehaslo"));
        Mockito.when(this.userRepository.getByLogin(Mockito.any()))
                .thenReturn(Optional.of(user));

        this.authenticationService.authenticate(login, password);

        Assertions.assertNull(this.sessionData.getUser());
        Mockito.verify(this.userRepository, Mockito.times(1))
                .getByLogin(Mockito.any());
    }

    @Test
    public void registerUserTest() throws LoginAlreadyExistException {
        User user = generateFakeUser("janusz123");
        String expectedPassword = DigestUtils.md5Hex("janusz123");

        this.authenticationService.register(user);

        final ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        Mockito.verify(this.userRepository, Mockito.times(1))
                .persistUser(captor.capture());
        final User actual = captor.getValue();
        Assertions.assertEquals(expectedPassword, actual.getPassword());
        Assertions.assertEquals(User.Role.USER, actual.getRole());
    }

    @Test
    public void loginAlreadyExistTest() throws LoginAlreadyExistException {
        User user = generateFakeUser("janusz123");
        Mockito.doThrow(LoginAlreadyExistException.class)
                .when(this.userRepository).persistUser(Mockito.any());

        Assertions.assertThrows(LoginAlreadyExistException.class,
                () -> this.authenticationService.register(user));
    }

    private User generateFakeUser(String password) {
        return new User(10, "janusz", password,
                "Janusz", "Kowalski", "janusz@gmail.com", User.Role.USER);
    }
}