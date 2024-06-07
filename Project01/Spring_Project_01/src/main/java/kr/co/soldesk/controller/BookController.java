package kr.co.soldesk.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import kr.co.soldesk.beans.BookDTO;
import kr.co.soldesk.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/bookList")
    public String getBookList(Model model) {
        List<BookDTO> bookList = bookService.getBookList();
        model.addAttribute("bookList", bookList);
        return "bookList";
    }

    @GetMapping("/addBook")
    public String showAddBookForm() {
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addBook(BookDTO book, Model model) {
        bookService.addBook(book);
        return "redirect:/bookList";
    }
}
