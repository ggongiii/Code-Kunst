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
		// WEB-INF / view / user 폴더의 login.jsp로 이동함
		// 그 이유는 ServletAppContext 클래스의
		// configureViewResolvers 메서드에서 그렇게 설정했기 때문임
	} // method
	
	@GetMapping("/join")
	public String myJoinPost(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		return "user/join";
		// WEB-INF / view / user 폴더의 join.jsp로 이동함
		// 그 이유는 ServletAppContext 클래스의
		// configureViewResolvers 메서드에서 그렇게 설정했기 때문임
	} // method
	
	  @PostMapping("join_pro") // GetMapping 아님
	   public String myJoinPro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean
	         // 위 코드는 UserBean joinUserBean = new UserBean();과 같음
	         , BindingResult result) {
	      if(result.hasErrors()) {
	         // 유효성 검사에서 에러로 판단된 경우
	         return "user/join";
	      } // if
	      
	      userService.addUserInfo(joinUserBean);
	      return "user/join_success";
	      // WEB-INF / view / user 폴더의 join_success.jsp로 이동함
	      // 그 이유는 ServletAppContext 클래스의
	      // configureViewResolvers 메서드에서 그렇게 설정했기 때문임
	   } // method
	   
	   @GetMapping("/modify")
	   public String myModify_user() {
	      return "user/modify";
	      // WEB-INF / view / user 폴더의 modify.jsp로 이동함
	      // 그 이유는 ServletAppContext 클래스의
	      // configureViewResolvers 메서드에서 그렇게 설정했기 때문임
	   } // method
	
	   @GetMapping("/logout")
	   public String myLogout() {
	      return "user/logout";
	      // WEB-INF / view / user 폴더의 logout.jsp로 이동함
	      // 그 이유는 ServletAppContext 클래스의
	      // configureViewResolvers 메서드에서 그렇게 설정했기 때문임
	   } // method
	   
	   // 유효성 검사를 위해 필요함 :  Validator를 등록하는 역할
	   @InitBinder // 최초로 읽고 감
	   public void initBinder(WebDataBinder binder) {
	      UserValidato validator1 = new UserValidator();
	      binder.addValidators(validator1);
	   } // method
	
	
	
} // main
