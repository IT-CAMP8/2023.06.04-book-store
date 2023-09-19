package pl.camp.it.book.store.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    public void getPrettyDateTest() {
        LocalDateTime date = LocalDateTime.of(2020, 10, 10,
                15, 30, 0);
        Order order = new Order(23423, new User(),
                Order.Status.NEW, 234.23444, date);
        String expected = "10.10.2020 15:30:00";

        String actual = order.getPrettyTime();

        assertEquals(expected, actual);
    }

}