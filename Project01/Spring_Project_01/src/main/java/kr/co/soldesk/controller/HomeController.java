package kr.co.soldesk.controller;



import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.soldesk.beans.LoginUserBean;



@Controller
public class HomeController {
	
	//�̸��� ���ؼ� ���
	@Resource(name="loginUserBean")
	private LoginUserBean loginUserBean;
	
	//�α��ν� ������������
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		System.out.println(loginUserBean);
		return "redirect:/main"; //
	}
}
