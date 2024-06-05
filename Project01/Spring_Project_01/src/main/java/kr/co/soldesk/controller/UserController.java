package kr.co.soldesk.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.soldesk.beans.UserBean;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/login")
	public String myLogin() {
		return "user/login";
		// WEB-INF / view / user ������ login.jsp�� �̵���
		// �� ������ ServletAppContext Ŭ������
		// configureViewResolvers �޼��忡�� �׷��� �����߱� ������
	} // method
	
	@GetMapping("/join")
	public String myJoinPost(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		return "user/join";
		// WEB-INF / view / user ������ join.jsp�� �̵���
		// �� ������ ServletAppContext Ŭ������
		// configureViewResolvers �޼��忡�� �׷��� �����߱� ������
	} // method
	
	  @PostMapping("join_pro") // GetMapping �ƴ�
	   public String myJoinPro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean
	         // �� �ڵ�� UserBean joinUserBean = new UserBean();�� ����
	         , BindingResult result) {
	      if(result.hasErrors()) {
	         // ��ȿ�� �˻翡�� ������ �Ǵܵ� ���
	         return "user/join";
	      } // if
	      
	      userService.addUserInfo(joinUserBean);
	      return "user/join_success";
	      // WEB-INF / view / user ������ join_success.jsp�� �̵���
	      // �� ������ ServletAppContext Ŭ������
	      // configureViewResolvers �޼��忡�� �׷��� �����߱� ������
	   } // method
	   
	   @GetMapping("/modify")
	   public String myModify_user() {
	      return "user/modify";
	      // WEB-INF / view / user ������ modify.jsp�� �̵���
	      // �� ������ ServletAppContext Ŭ������
	      // configureViewResolvers �޼��忡�� �׷��� �����߱� ������
	   } // method
	
	   @GetMapping("/logout")
	   public String myLogout() {
	      return "user/logout";
	      // WEB-INF / view / user ������ logout.jsp�� �̵���
	      // �� ������ ServletAppContext Ŭ������
	      // configureViewResolvers �޼��忡�� �׷��� �����߱� ������
	   } // method
	   
	   // ��ȿ�� �˻縦 ���� �ʿ��� :  Validator�� ����ϴ� ����
	   @InitBinder // ���ʷ� �а� ��
	   public void initBinder(WebDataBinder binder) {
	      UserValidato validator1 = new UserValidator();
	      binder.addValidators(validator1);
	   } // method
	
	
	
} // main
