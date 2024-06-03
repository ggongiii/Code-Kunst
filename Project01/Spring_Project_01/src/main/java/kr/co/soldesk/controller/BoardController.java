package kr.co.soldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	
	@GetMapping("/main")//원래 보드에 메인해야하는데 위해서 리퀘스트 매핑을해서 안해도됨
	public String main() {
		
		return "board/main"; //jsp
		
	}

}
