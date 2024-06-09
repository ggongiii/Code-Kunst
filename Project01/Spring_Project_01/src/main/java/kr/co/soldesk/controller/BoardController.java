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
        // WEB-INF / view / board 폴더의 main.jsp로 이동함
        // 그 이유는 ServletAppContext 클래스의
        // configureViewResolvers 메서드에서 그렇게 설정했기 때문임
    } // method
    
    @GetMapping("/read")
    public String myRead() {
        return "board/read";
        // WEB-INF / view / board 폴더의 read.jsp로 이동함
        // 그 이유는 ServletAppContext 클래스의
        // configureViewResolvers 메서드에서 그렇게 설정했기 때문임
    } // method
    
    @GetMapping("/modify")
    public String myModify() {
        return "board/modify";
        // WEB-INF / view / board 폴더의 modify.jsp로 이동함
        // 그 이유는 ServletAppContext 클래스의
        // configureViewResolvers 메서드에서 그렇게 설정했기 때문임
    } // method
    
    @GetMapping("/write")
    public String myWrite() {
        return "board/write";
        // WEB-INF / view / board 폴더의 write.jsp로 이동함
        // 그 이유는 ServletAppContext 클래스의
        // configureViewResolvers 메서드에서 그렇게 설정했기 때문임
    } // method
    
    @GetMapping("/delete")
    public String myDelete() {
        return "board/delete";
        // WEB-INF / view / board 폴더의 delete.jsp로 이동함
        // 그 이유는 ServletAppContext 클래스의
        // configureViewResolvers 메서드에서 그렇게 설정했기 때문임
    } // method
    
    @GetMapping("/page")
    public String page(Model model) {
    	 model.addAttribute("bookList", bookService.getBookList());
         return "board/page";
    	

        // WEB-INF / view / board 폴더의 page.jsp로 이동함
        // 그 이유는 ServletAppContext 클래스의
        // configureViewResolvers 메서드에서 그렇게 설정했기 때문임
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
