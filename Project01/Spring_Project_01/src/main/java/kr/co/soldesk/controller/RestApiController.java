package kr.co.soldesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.soldesk.service.UserService;


//유저서비스
@RestController
public class RestApiController {
	
	@Autowired
	private UserService userService;
	
	//아이디 중복검사
	@GetMapping("/user/checkUserIdExist/{user_id}")
	public String checkUserIdExist(@PathVariable String user_id) {
		//@PathVariable: 주소에 데이터 붙이기
		boolean chk=userService.checkUserIdExist(user_id);
		return chk+"";
	}
	
	//이메일 중복검사
	@GetMapping("/user/checkUserEmailExist/{email}")
	public String checkUserEmailExist(@PathVariable String email) {
		//@PathVariable: 주소에 데이터 붙이기
		boolean chk=userService.checkUserEmailExist(email);
		return chk+"";
	}
	
	//닉네임 중복검사
	@GetMapping("/user/checkUserNicknameExist/{user_nickname}")
	public String checkUserNicknameExist(@PathVariable String user_nickname) {
		//@PathVariable: 주소에 데이터 붙이기
		boolean chk=userService.checkUserNicknameExist(user_nickname);
		return chk+"";
	}

}