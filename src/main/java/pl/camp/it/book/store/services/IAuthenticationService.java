package pl.camp.it.book.store.services;

import pl.camp.it.book.store.exceptions.LoginAlreadyExistException;
import pl.camp.it.book.store.model.User;

public interface IAuthenticationService {
    boolean authenticateWithReturn(String login, String password);
    void authenticate(String login, String password);
    void logout();
    void register(User user) throws LoginAlreadyExistException;
}
