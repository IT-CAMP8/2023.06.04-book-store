package pl.camp.it.book.store.database.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.book.store.database.IUserRepository;
import pl.camp.it.book.store.model.User;

import java.sql.Connection;
import java.util.Optional;

@Repository
public class UserDAO implements IUserRepository {

    @Autowired
    Connection connection;

    @Override
    public Optional<User> getByLogin(String login) {
        return Optional.empty();
    }

    @Override
    public void persistUser(User user) {

    }
}
