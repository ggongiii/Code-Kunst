package kr.co.soldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
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
	
	@GetMapping("/bestSeller")
	public String bestSeller() {
		return "board/bestSeller";
		// WEB-INF / view / board ������ delete.jsp�� �̵���
		// �� ������ ServletAppContext Ŭ������
		// configureViewResolvers �޼��忡�� �׷��� �����߱� ������
	} // method
	
} // class
