package pl.camp.it.book.store.controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.camp.it.book.store.model.Book;
import pl.camp.it.book.store.services.IAuthenticationService;
import pl.camp.it.book.store.services.IBookService;
import pl.camp.it.book.store.services.impl.AuthenticationServiceImpl;
import pl.camp.it.book.store.session.SessionData;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommonController {
    @Autowired
    private IBookService bookService;

    @Autowired
    IAuthenticationService authenticationService;

    @Resource
    SessionData sessionData;

    @GetMapping(path = {"/main", "/"})
    public String main(Model model,
                       @RequestParam(required = false) String pattern) {
        if(!this.sessionData.isLogged()) {
            model.addAttribute("books", new ArrayList<>());
        } else if(pattern == null) {
            model.addAttribute("books", this.bookService.getAllBooks());
        } else {
            model.addAttribute("books", this.bookService.getFilteredBooks(pattern));
        }
        return "index";
    }

    @RequestMapping(path = "/contact", method = RequestMethod.GET)
    public String contact() {
        return "contact";
    }
}
