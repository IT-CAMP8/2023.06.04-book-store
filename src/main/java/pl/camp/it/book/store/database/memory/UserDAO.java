package pl.camp.it.book.store.database.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.book.store.database.IUserRepository;
import pl.camp.it.book.store.database.sequence.IUserIdSequence;
import pl.camp.it.book.store.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO implements IUserRepository {

    IUserIdSequence userIdSequence;
    private final List<User> users = new ArrayList<>();

    public UserDAO(@Autowired IUserIdSequence userIdSequence) {
        this.users.add(new User(userIdSequence.getId(), "admin",
                "21232f297a57a5a743894a0e4a801fc3",
                "Karol", "Krawczyk", "karol.krawczyk@gmail.com",
                User.Role.ADMIN));
        this.users.add(new User(userIdSequence.getId(), "janusz",
                "087d9c5e13bdd64a82bef8e013625c32",
                "Janusz", "Kowalski", "janusz.kowalski@gmail.com",
                User.Role.USER));
        this.userIdSequence = userIdSequence;
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
        user.setId(this.userIdSequence.getId());
        this.users.add(user);
    }
}
