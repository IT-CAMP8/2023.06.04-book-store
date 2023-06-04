package pl.camp.it.book.store.database.memory;

import org.springframework.stereotype.Repository;
import pl.camp.it.book.store.database.IBookDAO;
import pl.camp.it.book.store.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDAO implements IBookDAO {

    private final List<Book> books = new ArrayList<>();
    private int lastId = 4;

    public BookDAO() {
        this.books.add(new Book(1, "Java EE 6. Tworzenie aplikacji w NetBeans 7", "David R. Heffelfinger", 59.00, 10, "978-83-246-8936-1"));
        this.books.add(new Book(2, "Java. Rusz głową! Wydanie III", "Kathy Sierra, Bert Bates, Trisha Gee", 95.36, 10, "978-83-283-9984-6"));
        this.books.add(new Book(3, "Java. Przewodnik dla początkujących. Wydanie VIII", "Herbert Schildt", 61.38, 10, "978-83-283-9118-5"));
        this.books.add(new Book(4, "Java. Efektywne programowanie. Wydanie III", "Joshua Bloch", 60.39, 10, "978-83-283-9896-2"));
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(this.books);
    }

    @Override
    public void persistBook(Book book) {
        book.setId(++this.lastId);
        this.books.add(book);
    }

    @Override
    public Book getBookById(int id) {
        for(Book book : this.books) {
            if(book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void deleteBook(int id) {
        for(Book book : this.books) {
            if(book.getId() == id) {
                this.books.remove(book);
                return;
            }
        }
    }
}
