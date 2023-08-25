package pl.camp.it.book.store.controllers.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.camp.it.book.store.model.Book;
import pl.camp.it.book.store.model.User;

@RestController
@RequestMapping(path = "/api")
public class TestRestController {

    @RequestMapping(path = "/test1", method = RequestMethod.GET)
    public User test1() {
        User user = new User();
        user.setId(5);
        user.setRole(User.Role.ADMIN);
        user.setPassword("aksjhdgfkjahgsdkjfh33245kjh23");
        user.setSurname("Kowalski");
        user.setLogin("janusz");
        user.setEmail("janusz.kowalski@gmail.com");
        user.setName("Janusz");

        return user;
    }

    @RequestMapping(path = "/test2/{param}", method = RequestMethod.POST)
    public Book test2(@PathVariable String param,
                      @RequestParam int a,
                      @RequestHeader String header1,
                      @RequestHeader String header2,
                      @RequestBody User user) {
        System.out.println(param);
        System.out.println(a);
        System.out.println(header1);
        System.out.println(header2);
        System.out.println(user);

        Book book = new Book(13, "Jakis tytul", "Jakis Autor",
                55.55, 10, "234-2-234-234-2-323");
        return book;
    }

    @RequestMapping(path = "/test3", method = RequestMethod.GET)
    public ResponseEntity<Book> test3() {
        Book book = new Book(13, "Jakis tytul", "Jakis Autor",
                55.55, 10, "234-2-234-234-2-323");

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .header("header1", "wartosc1")
                .header("header2", "wartosc2")
                .body(book);
    }
}
