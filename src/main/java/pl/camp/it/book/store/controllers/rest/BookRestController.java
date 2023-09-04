package pl.camp.it.book.store.controllers.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.camp.it.book.store.model.Book;
import pl.camp.it.book.store.model.dto.BookListResponse;
import pl.camp.it.book.store.model.dto.ListResponse;
import pl.camp.it.book.store.services.IBookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/book")
public class BookRestController {

    @Autowired
    IBookService bookService;

    @Operation(description = "fajny endpoint do pobierania ksiazek", summary = "getBooks")
    @RequestMapping(method = RequestMethod.GET)
    public ListResponse<Book> getBooks(@Parameter(example = "java", description = "pattern w tytule lub autorze ktory bedzie wyszukiwany")
                                         @RequestParam(required = false)
                                         String pattern) {
        if(pattern == null) {
            return new ListResponse<>(this.bookService.getAllBooks());
        }
        return new ListResponse<>(this.bookService.getFilteredBooks(pattern));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        book.setId(0);
        Optional<Book> bookFromDb = this.bookService.persistBook(book);
        return bookFromDb.map(value -> ResponseEntity.status(HttpStatus.CREATED).body(value))
                        .orElseGet(() -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Optional<Book> bookBox = this.bookService.getBookById(id);
        return bookBox.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        book.setId(id);
        if(this.bookService.getBookById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Optional<Book> bookFromDbBox = this.bookService.updateBook(book);
        return bookFromDbBox.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable int id) {
        this.bookService.deleteBook(id);
    }
}
