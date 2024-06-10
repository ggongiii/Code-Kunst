package kr.co.soldesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import kr.co.soldesk.service.BookService;

@Controller
public class MainController {

    @Autowired
    private BookService bookService;

    @GetMapping("/main")
    public String myMain(Model model) {
        model.addAttribute("bookList", bookService.getBookList());
        // 여기 메뉴바영역 : 필요한 경우 다른 리스트를 추가
        model.addAttribute("soccer", bookService.getBookList()); // 메뉴바 1번항목
        model.addAttribute("newReleases", bookService.getBookList()); //  메뉴바 2번항목
        model.addAttribute("steadySellers", bookService.getBookList()); //  메뉴바 3번항목
        model.addAttribute("comics", bookService.getBookList()); //  메뉴바 4번항목
        return "main";
        // WEB-INF/views 폴더의 main.jsp로 이동함
        // 그 이유는 ServletAppContext 클래스의
        // configureViewResolvers 메서드에서 그렇게 설정했기 때문임
    } // method
    
} // class
