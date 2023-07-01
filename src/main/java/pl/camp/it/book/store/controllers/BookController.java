package pl.camp.it.book.store.controllers;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.book.store.model.Book;
import pl.camp.it.book.store.session.SessionData;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    @Resource
    SessionData sessionData;

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addBook(Model model) {
        if(!this.sessionData.isAdmin()) {
            return "redirect:/main";
        }
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        model.addAttribute("bookModel", new Book());
        return "add-book";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute Book book) {
        System.out.println(book); //TODO dodać do bazy !!!
        return "redirect:/main";
    }

    /*@RequestMapping(path = "/update", method = RequestMethod.GET)
    public String updateBook() {
        return "";
    }*/

}
