package kr.co.soldesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.soldesk.beans.BookDTO;
import kr.co.soldesk.service.BookService;

@Controller
@RequestMapping("/board")
public class BoardController {
    
    @Autowired
    private BookService bookService;

    @GetMapping("/main")
    public String myMain() {
        return "board/main";
        // WEB-INF / view / board ������ main.jsp�� �̵���
        // �� ������ ServletAppContext Ŭ������
        // configureViewResolvers �޼��忡�� �׷��� �����߱� ������
    } // method
    
    @GetMapping("/read")
    public String myRead() {
        return "board/read";
        // WEB-INF / view / board ������ read.jsp�� �̵���
        // �� ������ ServletAppContext Ŭ������
        // configureViewResolvers �޼��忡�� �׷��� �����߱� ������
    } // method
    
    @GetMapping("/modify")
    public String myModify() {
        return "board/modify";
        // WEB-INF / view / board ������ modify.jsp�� �̵���
        // �� ������ ServletAppContext Ŭ������
        // configureViewResolvers �޼��忡�� �׷��� �����߱� ������
    } // method
    
    @GetMapping("/write")
    public String myWrite() {
        return "board/write";
        // WEB-INF / view / board ������ write.jsp�� �̵���
        // �� ������ ServletAppContext Ŭ������
        // configureViewResolvers �޼��忡�� �׷��� �����߱� ������
    } // method
    
    @GetMapping("/delete")
    public String myDelete() {
        return "board/delete";
        // WEB-INF / view / board ������ delete.jsp�� �̵���
        // �� ������ ServletAppContext Ŭ������
        // configureViewResolvers �޼��忡�� �׷��� �����߱� ������
    } // method
    
    @GetMapping("/page")
    public String page(Model model) {
    	 model.addAttribute("bookList", bookService.getBookList());
         return "board/page";
    	

        // WEB-INF / view / board ������ page.jsp�� �̵���
        // �� ������ ServletAppContext Ŭ������
        // configureViewResolvers �޼��忡�� �׷��� �����߱� ������
    } // method
    
    @GetMapping("/bookDetail")
    public String bookDetail(@RequestParam("bookId") int bookId, Model model) {
        BookDTO book = bookService.getBookById(bookId);
        model.addAttribute("book", book);

        List<BookDTO> recommendedBooks = bookService.getRandomBooksByCategory(book.getBook_category(), 5);
        model.addAttribute("recommendedBooks", recommendedBooks);

        return "board/bookDetail";
    }
    
} // class
