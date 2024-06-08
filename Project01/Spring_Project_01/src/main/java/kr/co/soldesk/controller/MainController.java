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
        // �ʿ��� ��� �ٸ� ����Ʈ�� �߰�
        model.addAttribute("recommendedBooks", bookService.getBookList()); // ���� ������
        model.addAttribute("newReleases", bookService.getBookList()); // ���� ������
        model.addAttribute("steadySellers", bookService.getBookList()); // ���� ������
        model.addAttribute("comics", bookService.getBookList()); // ���� ������
        return "main";
        // WEB-INF/views ������ main.jsp�� �̵���
        // �� ������ ServletAppContext Ŭ������
        // configureViewResolvers �޼��忡�� �׷��� �����߱� ������
    } // method
    
} // class
