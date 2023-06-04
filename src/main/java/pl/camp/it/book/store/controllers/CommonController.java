package pl.camp.it.book.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.camp.it.book.store.model.Book;
import pl.camp.it.book.store.services.IBookService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommonController {
    @Autowired
    private IBookService bookService;

    //private List<Book> filteredBooks = null;

    //@RequestMapping(path = "/main", method = RequestMethod.GET)
    @GetMapping(path = "/main")
    public String main(Model model,
                       @RequestParam(required = false) String pattern) {
        if(pattern == null) {
            model.addAttribute("books", this.bookService.getAllBooks());
        } else {
            model.addAttribute("books", this.bookService.getFilteredBooks(pattern));
        }
        return "index";
    }

    //@RequestMapping(path = "/main", method = RequestMethod.POST)
    /*@PostMapping(path = "/main")
    public String main(Model model,
                       @RequestParam String pattern) {
        this.filteredBooks = this.bookService.getFilteredBooks(pattern);
        return "redirect:/main";
    }*/

    @RequestMapping(path = "/contact", method = RequestMethod.GET)
    public String contact() {
        return "contact";
    }
}
