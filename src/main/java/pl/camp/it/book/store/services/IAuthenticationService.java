package pl.camp.it.book.store.services;

public interface IAuthenticationService {
    boolean authenticateWithReturn(String login, String password);
    void authenticate(String login, String password);
    void logout();
}
