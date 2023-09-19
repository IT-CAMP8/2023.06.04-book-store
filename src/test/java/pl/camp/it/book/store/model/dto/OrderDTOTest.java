package pl.camp.it.book.store.model.dto;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.camp.it.book.store.controllers.rest.RestConstants;
import pl.camp.it.book.store.model.Book;
import pl.camp.it.book.store.model.Order;
import pl.camp.it.book.store.model.OrderPosition;
import pl.camp.it.book.store.model.User;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OrderDTOTest {

    @Test
    public void orderToOrderDTOMappingTest() {
        LocalDateTime date = LocalDateTime.of(2020, 10, 10,
                15, 30, 0);
        Order order = new Order(15, new User(15),
                Order.Status.NEW, 50.0, date);
        order.getOrderPositions().add(new OrderPosition(1, new Book(), 234));
        order.getOrderPositions().add(new OrderPosition(2, new Book(), 234));
        order.getOrderPositions().add(new OrderPosition(3, new Book(), 234));
        RestConstants.API_LOCATION = "http://localhost:8080/api/v1/";

        String expectedUser = "http://localhost:8080/api/v1/user/15";
        Set<String> expectedOrderPositions = Set.of(
                "http://localhost:8080/api/v1/order-position/1",
                "http://localhost:8080/api/v1/order-position/2",
                "http://localhost:8080/api/v1/order-position/3"
        );

        OrderDTO actual = new OrderDTO(order);

        assertEquals(order.getId(), actual.getId());
        assertEquals(expectedUser, actual.getUser());
        assertEquals(expectedOrderPositions, actual.getOrderPositions());
        assertEquals(Order.Status.NEW, actual.getStatus());
        assertEquals(order.getTotal(), actual.getTotal());
        assertEquals(date, actual.getDateTime());
    }

}