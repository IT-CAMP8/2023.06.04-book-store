package pl.camp.it.book.store.database.memory;

import org.springframework.stereotype.Repository;
import pl.camp.it.book.store.database.IUserRepository;
import pl.camp.it.book.store.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO implements IUserRepository {

    private final List<User> users = new ArrayList<>();

    private int lastId = 2;

    public UserDAO() {
        this.users.add(new User(1, "admin",
                "21232f297a57a5a743894a0e4a801fc3",
                "Karol", "Krawczyk", "karol.krawczyk@gmail.com",
                User.Role.ADMIN));
        this.users.add(new User(2, "janusz",
                "087d9c5e13bdd64a82bef8e013625c32",
                "Janusz", "Kowalski", "janusz.kowalski@gmail.com",
                User.Role.USER));
    }

    @Override
    public User getByLogin(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return User.copyOf(user);
            }
        }

        return null;
    }

    @Override
    public void persistUser(User user) {
        user.setId(++this.lastId);
        this.users.add(user);
    }
}
