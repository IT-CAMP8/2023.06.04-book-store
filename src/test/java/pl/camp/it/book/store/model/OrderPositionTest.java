package pl.camp.it.book.store.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderPositionTest {

    @Test
    public void incrementOrderPositionQuantityTest() {
        OrderPosition orderPosition = new OrderPosition(1231, new Book(), 7);
        int expectedQuantity = 8;

        orderPosition.incrementQuantity();

        assertEquals(expectedQuantity, orderPosition.getQuantity());
    }

}