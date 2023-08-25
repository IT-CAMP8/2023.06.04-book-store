package pl.camp.it.book.store.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.book.store.database.IUserRepository;
import pl.camp.it.book.store.exceptions.LoginAlreadyExistException;
import pl.camp.it.book.store.model.User;
import pl.camp.it.book.store.services.IUserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Optional<User> getByLogin(String login) {
        return this.userRepository.getByLogin(login);
    }

    @Override
    public Optional<User> getById(int id) {
        return this.userRepository.getById(id);
    }

    @Override
    public void persistUser(User user) throws LoginAlreadyExistException {
        this.userRepository.persistUser(user);
    }
}
