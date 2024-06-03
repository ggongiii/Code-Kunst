package kr.co.soldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		////////////////////return "index"; 
		// WEB-INF / view 폴더의 index.jsp로 이동함
		// 그 이유는 ServletAppContext 클래스의
		// configureViewResolvers 메서드에서 그렇게 설정했기 때문임
		
		return "redirect:/main"; // redirect: -> 주소 재요청
		// MainController 참고
	} // method
} // class
