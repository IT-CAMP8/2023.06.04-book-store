package pl.camp.it.book.store.database.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.book.store.database.IBookDAO;
import pl.camp.it.book.store.model.Book;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDAO implements IBookDAO {

    @Autowired
    Connection connection;

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public void persistBook(Book book) {

    }

    @Override
    public Optional<Book> getBookById(int id) {
        return Optional.empty();
    }

    @Override
    public boolean deleteBook(int id) {
        return false;
    }

    @Override
    public void updateBook(Book book) {

    }
}
