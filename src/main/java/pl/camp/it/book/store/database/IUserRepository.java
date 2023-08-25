package pl.camp.it.book.store.database;

import pl.camp.it.book.store.exceptions.LoginAlreadyExistException;
import pl.camp.it.book.store.model.User;

import java.util.Optional;

public interface IUserRepository {
    Optional<User> getByLogin(String login);
    Optional<User> getById(int id);
    void persistUser(User user) throws LoginAlreadyExistException;
}
