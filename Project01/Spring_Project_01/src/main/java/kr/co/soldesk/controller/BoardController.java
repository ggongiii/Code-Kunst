package kr.co.soldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	
	@GetMapping("/main")//���� ���忡 �����ؾ��ϴµ� ���ؼ� ������Ʈ �������ؼ� ���ص���
	public String main() {
		
		return "board/main"; //jsp
		
	}

}
