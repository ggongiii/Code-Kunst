package kr.co.soldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/main")
	public String myMain() {
		return "main";
		// WEB-INF / view 폴더의 main.jsp로 이동함
		// 그 이유는 ServletAppContext 클래스의
		// configureViewResolvers 메서드에서 그렇게 설정했기 때문임
	} // method
	
} // class
