package pl.camp.it.book.store.services;

import pl.camp.it.book.store.exceptions.LoginAlreadyExistException;
import pl.camp.it.book.store.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> getByLogin(String login);
    Optional<User> getById(int id);
    void persistUser(User user) throws LoginAlreadyExistException;
}
