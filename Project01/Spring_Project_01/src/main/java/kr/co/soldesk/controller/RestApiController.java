package kr.co.soldesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.soldesk.service.UserService;



@RestController
public class RestApiController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/user/checkUserIdExist/{user_id}")
	public String cherckUserIdExist(@PathVariable String user_id){
		//@PathVariable : �ּҿ� ������ ���̱�
		boolean chk = userService.checkUserExist(user_id);
		return chk+"";
		
	}
	
	
}
