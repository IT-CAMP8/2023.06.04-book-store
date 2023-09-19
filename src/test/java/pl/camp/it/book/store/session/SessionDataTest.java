package pl.camp.it.book.store.session;

import org.junit.jupiter.api.Test;
import pl.camp.it.book.store.model.User;

import static org.junit.jupiter.api.Assertions.*;

class SessionDataTest {

    @Test
    public void isUserNotLoggedTest() {
        SessionData sessionData = new SessionData();
        sessionData.setUser(null);
        assertFalse(sessionData.isLogged());
    }

    @Test
    public void isUserNullByDefaultTest() {
        assertNull(new SessionData().getUser());
    }

    @Test
    public void isUserLoggedTest() {
        SessionData sessionData = new SessionData();
        sessionData.setUser(new User());
        assertTrue(sessionData.isLogged());
    }

    @Test
    public void isNotLoggedUserAdminTest() {
        SessionData sessionData = new SessionData();
        sessionData.setUser(null);
        assertFalse(sessionData.isAdmin());
    }

    @Test
    public void isLoggedUserAdminTest() {
        SessionData sessionData = new SessionData();
        sessionData.setUser(new User(23455, "dfsgsd",
                "alkshjdfg",
                "sdfsdf", "sdfgsdf", "sdfgsdf",
                User.Role.ADMIN));
        assertTrue(sessionData.isAdmin());
    }

    @Test
    public void isLoggedUserNotAdminTest() {
        SessionData sessionData = new SessionData();
        sessionData.setUser(new User(23455, "dfsgsd",
                "alkshjdfg",
                "sdfsdf", "sdfgsdf", "sdfgsdf",
                User.Role.USER));
        assertFalse(sessionData.isAdmin());
    }

    @Test
    public void getInfoIfNotNullTest() {
        SessionData sessionData = new SessionData();
        sessionData.setInfo("info");
        String expected = "info";
        String expected2 = "";

        String actual = sessionData.getInfo();
        String actual2 = sessionData.getInfo();

        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
    }

    @Test
    public void getInfoIfNullTest() {
        SessionData sessionData = new SessionData();
        sessionData.setInfo(null);
        String expected = "";
        String expected2 = "";

        String actual = sessionData.getInfo();
        String actual2 = sessionData.getInfo();

        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
    }
}