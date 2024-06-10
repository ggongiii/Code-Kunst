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
import kr.co.soldesk.beans.YouTubeDto;
 import kr.co.soldesk.youtube.YouTubeSearch;


@Controller
@RequestMapping("/board")
public class BoardController {
    //책API
    @Autowired
    private BookService bookService;
    //유튜브API
    @Autowired
    private YouTubeSearch youTubeSearch;
	//--여기부터--
    @GetMapping("/main")
    public String myMain() {
        return "board/main";
    } 
    
    @GetMapping("/read")
    public String myRead() {
        return "board/read";
    } 
    
    @GetMapping("/modify")
    public String myModify() {
        return "board/modify";
    }
    
    @GetMapping("/write")
    public String myWrite() {
        return "board/write";
    }
    
    @GetMapping("/delete")
    public String myDelete() {
        return "board/delete";
    } 
    
    @GetMapping("/page")
    public String page(Model model) {
        model.addAttribute("bookList", bookService.getBookList());
        return "board/page";
    } 
    
    @GetMapping("/bookDetail")
    public String bookDetail(@RequestParam("bookId") int bookId, Model model) {
        BookDTO book = bookService.getBookById(bookId);
        model.addAttribute("book", book);

        List<BookDTO> recommendedBooks = bookService.getRandomBooksByCategory(book.getBook_category(), 5);
        model.addAttribute("recommendedBooks", recommendedBooks);

        // YouTube 랜덤 하게
        List<YouTubeDto> allVideos = youTubeSearch.searchVideos(book.getBook_category() + " 추천");
        List<YouTubeDto> recommendedVideos = youTubeSearch.getRandomVideos(allVideos, 3);
        model.addAttribute("recommendedVideos", recommendedVideos);

        return "board/bookDetail";
    }
} // class
