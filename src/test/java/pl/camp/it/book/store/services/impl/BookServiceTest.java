package pl.camp.it.book.store.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import pl.camp.it.book.store.model.Book;
import pl.camp.it.book.store.services.IBookService;

import java.util.ArrayList;
import java.util.List;

class BookServiceTest extends ServiceGenericTest {

    @Autowired
    IBookService bookService;

    @Test
    public void getAllBooksTest() {
        int expectedListSize = 4;
        List<Integer> expectedBookIds = List.of(1,2,3,4);
        Mockito.when(this.bookDAO.getAllBooks()).thenReturn(generateFakeBooks());

        List<Book> actual = this.bookService.getAllBooks();

        Assertions.assertEquals(expectedListSize, actual.size());
        List<Integer> ids = actual.stream().map(Book::getId).toList();
        Assertions.assertTrue(ids.containsAll(expectedBookIds));
        Mockito.verify(this.bookDAO, Mockito.times(1))
                .getAllBooks();
    }

    private List<Book> generateFakeBooks() {
        List<Book> result = new ArrayList<>();
        result.add(new Book(1, "Java. Efektywne programowanie. Wydanie III",
                "Joshua Bloch", 60.39, 10, "978-83-283-9896-2"));
        result.add(new Book(2, "Java EE 6. Tworzenie aplikacji w NetBeans 7",
                "David R. Heffelfinger", 59.00, 10, "978-83-246-8936-1"));
        result.add(new Book(3, "Java. Rusz głową! Wydanie III",
                "Kathy Sierra, Bert Bates, Trisha Gee", 95.36, 10,
                "978-83-283-9984-6"));
        result.add(new Book(4, "Java. Przewodnik dla początkujących. Wydanie VIII",
                "Herbert Schildt", 61.38, 10, "978-83-283-9118-5"));
        return result;
    }
}