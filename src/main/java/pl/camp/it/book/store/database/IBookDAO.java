package pl.camp.it.book.store.database;

import pl.camp.it.book.store.model.Book;

import java.util.List;

public interface IBookDAO {
    List<Book> getAllBooks();
    void persistBook(Book book);
    Book getBookById(int id);
    void deleteBook(int id);
    void updateBook(Book book);
}
