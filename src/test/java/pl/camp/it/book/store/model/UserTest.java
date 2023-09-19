package pl.camp.it.book.store.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void copyUserTest() {
        User user = new User(2344, "sdfg",
                "sdfgsd",
                "sdfgsd", "sdfggfds", "sdfgfgd",
                User.Role.ADMIN);

        User copiedUser = User.copyOf(user);

        assertNotSame(user, copiedUser);
        assertEquals(user.getId(), copiedUser.getId());
        assertEquals(user.getName(), copiedUser.getName());
        assertEquals(user.getSurname(), copiedUser.getSurname());
        assertEquals(user.getEmail(), copiedUser.getEmail());
        assertEquals(user.getPassword(), copiedUser.getPassword());
        assertEquals(user.getLogin(), copiedUser.getLogin());
        assertEquals(user.getRole(), copiedUser.getRole());
    }

}