package pl.camp.it.book.store.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.camp.it.book.store.exceptions.BookValidationException;
import pl.camp.it.book.store.model.Book;

public class BookValidatorTest {

    @Test
    public void correctTitleTest() {
        String title = "title";

        BookValidator.validateTitle(title);
    }

    @Test
    public void incorrectTitleTest() {
        String title = "";

        Assertions.assertThrows(BookValidationException.class,
                () -> BookValidator.validateTitle(title));
    }

    @Test
    public void correctAuthorWithOneNameAndOneSurnameTest() {
        String author = "Janusz Kowalski";

        BookValidator.validateAuthor(author);
    }

    @Test
    public void incorrectAuthorWithWrongNameAndOneSurnameTest() {
        String author = "janusz Kowalski";

        Assertions.assertThrows(BookValidationException.class,
                () -> BookValidator.validateAuthor(author));
    }

    @Test
    public void incorrectAuthorWithoutSpaceBetweenNameAndSurnameTest() {
        String author = "JanuszKowalski";

        Assertions.assertThrows(BookValidationException.class,
                () -> BookValidator.validateAuthor(author));
    }

    @Test
    public void correctISBNTest() {
        String isbn = "979-34-123-1234-0";

        BookValidator.validateISBN(isbn);
    }

    @Test
    public void incorrectISBNTest() {
        String isbn = "777-34-123-1234-0";

        Assertions.assertThrows(BookValidationException.class,
                () -> BookValidator.validateISBN(isbn));
    }

    @Test
    public void correctBookTest() {
        Book book = new Book(1, "Tytul", "Janusz Kowalski",
                50.00, 10, "979-34-123-1234-0");

        BookValidator.validateBook(book);
    }

    @Test
    public void bookWithIncorrectTitleTest() {
        Book book = new Book(1, "", "Janusz Kowalski",
                50.00, 10, "979-34-123-1234-0");

        Assertions.assertThrows(BookValidationException.class,
                () -> BookValidator.validateBook(book));
    }
}
