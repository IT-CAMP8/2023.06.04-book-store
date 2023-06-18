package pl.camp.it.book.store.services.impl;

import jakarta.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.book.store.database.IUserRepository;
import pl.camp.it.book.store.model.User;
import pl.camp.it.book.store.services.IAuthenticationService;
import pl.camp.it.book.store.session.SessionData;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    IUserRepository userRepository;

    @Resource
    SessionData sessionData;

    @Override
    public boolean authenticateWithReturn(String login, String password) {
        /*User user = this.userRepository.getByLogin(login);
        this.logged = user != null && user.getPassword().equals(DigestUtils.md5Hex(password));
        return this.logged;*/
        return false;
    }

    @Override
    public void authenticate(String login, String password) {
        User user = this.userRepository.getByLogin(login);
        this.sessionData.setLogged(user != null && user.getPassword().equals(DigestUtils.md5Hex(password)));
    }

    @Override
    public void logout() {
        this.sessionData.setLogged(false);
    }
}
