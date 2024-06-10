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
        // ���� �޴��ٿ��� : �ʿ��� ��� �ٸ� ����Ʈ�� �߰�
        model.addAttribute("soccer", bookService.getBookList()); // �޴��� 1���׸�
        model.addAttribute("newReleases", bookService.getBookList()); //  �޴��� 2���׸�
        model.addAttribute("steadySellers", bookService.getBookList()); //  �޴��� 3���׸�
        model.addAttribute("comics", bookService.getBookList()); //  �޴��� 4���׸�
        return "main";
        // WEB-INF/views ������ main.jsp�� �̵���
        // �� ������ ServletAppContext Ŭ������
        // configureViewResolvers �޼��忡�� �׷��� �����߱� ������
    } // method
    
} // class
