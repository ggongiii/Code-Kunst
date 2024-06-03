package kr.co.soldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/main")
	public String myMain() {
		return "main";
		// WEB-INF / view ������ main.jsp�� �̵���
		// �� ������ ServletAppContext Ŭ������
		// configureViewResolvers �޼��忡�� �׷��� �����߱� ������
	} // method
	
} // class
