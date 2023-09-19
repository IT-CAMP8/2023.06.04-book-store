package pl.camp.it.book.store.model.dto;

import org.junit.jupiter.api.Test;
import pl.camp.it.book.store.controllers.rest.RestConstants;
import pl.camp.it.book.store.model.Book;
import pl.camp.it.book.store.model.Order;
import pl.camp.it.book.store.model.OrderPosition;

import static org.junit.jupiter.api.Assertions.*;

class OrderPositionResponseDTOTest {

    @Test
    public void orderPositionToOrderPositionDTOMappingTest() {
        OrderPosition orderPosition = new OrderPosition(10, new Book(1),
                5, new Order(17));
        RestConstants.API_LOCATION = "http://localhost:8080/api/v1/";
        String expectedBook = "http://localhost:8080/api/v1/book/1";
        String expectedOrder = "http://localhost:8080/api/v1/order/17";

        OrderPositionResponseDTO actual = new OrderPositionResponseDTO(orderPosition);

        assertEquals(orderPosition.getId(), actual.getId());
        assertEquals(expectedBook, actual.getBook());
        assertEquals(orderPosition.getQuantity(), actual.getQuantity());
        assertEquals(expectedOrder, actual.getOrder());
    }

}