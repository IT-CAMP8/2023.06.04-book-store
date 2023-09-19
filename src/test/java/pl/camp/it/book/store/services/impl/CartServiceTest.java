package pl.camp.it.book.store.services.impl;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.camp.it.book.store.model.Book;
import pl.camp.it.book.store.model.OrderPosition;
import pl.camp.it.book.store.services.ICartService;
import pl.camp.it.book.store.session.SessionData;

import java.util.Optional;

@WebAppConfiguration
public class CartServiceTest extends ServiceGenericTest {

    @Autowired
    ICartService cartService;

    @Resource
    SessionData sessionData;

    @Test
    public void addProductToEmptyCartTest() {
        int bookId = 5;
        int expectedBooksCount = 1;
        Book expectedBook = generateFakeBook();
        Mockito.when(this.bookDAO.getBookById(5)).thenReturn(Optional.of(expectedBook));
        OrderPosition expectedOrderPosition = new OrderPosition();
        expectedOrderPosition.setBook(expectedBook);
        expectedOrderPosition.setQuantity(1);

        this.cartService.addProductToCart(bookId);

        Assertions.assertEquals(expectedBooksCount,
                this.sessionData.getCart().getPositions().size());
        Assertions.assertTrue(
                this.sessionData.getCart().getPositions().contains(expectedOrderPosition));
    }

    private Book generateFakeBook() {
        return new Book(5, "", "Janusz Kowalski",
                50.00, 10, "979-34-123-1234-0");
    }
}
