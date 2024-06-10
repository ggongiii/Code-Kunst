package kr.co.soldesk.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.soldesk.beans.FindIdUserBean;
import kr.co.soldesk.beans.FindPwUserBean;
import kr.co.soldesk.beans.LoginUserBean;
import kr.co.soldesk.beans.UserBean;
import kr.co.soldesk.service.UserService;
import kr.co.soldesk.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserService userService;
    
    //�α���
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginUserBean", new LoginUserBean());
        return "user/login";
    }
    
  //�α���
    @PostMapping("/login_pro")
    public String login_pro(@Valid @ModelAttribute("loginUserBean") LoginUserBean loginUserBean, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "user/login";
        }
        //��������
        boolean loginResult = userService.checkUser(loginUserBean);

        if (loginResult) {
            loginUserBean.setUserLogin(true); // �α��� ���� �� userLogin�� true�� ����
            session.setAttribute("loggedInUser", loginUserBean);
            return "user/login_success"; // �α��� ���� �������� �̵�
        } else {
            return "user/login_fail"; // �α��� ���� �������� �̵�
        }
    }
    
    
    
    
    
    
    
	
    //ȸ������
    @GetMapping("/join")
    public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
        return "user/join";
    }
    
    //ȸ������
    @PostMapping("/join_pro")
    public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {
        if (result.hasErrors()) {
            return "user/join";
        }
        userService.addUserInfo(joinUserBean);
        return "user/join_success";
    }
    /* ���̵� ã�� */
    @GetMapping("/find_id")
	public String findIdForm(@ModelAttribute("FindIdBean") FindIdUserBean findIdBean) {
		return "user/find_id";
	}
	
	@PostMapping("/find_id_pro")
	public String findIdSubmit(@Valid @ModelAttribute("FindIdBean") FindIdUserBean findIdBean, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "user/find_id";
		}
		//��������
		String user_id = userService.findUserId(findIdBean.getUser_name(), findIdBean.getEmail(), findIdBean.getPhone());
		if (user_id != null) {
			model.addAttribute("user_id", user_id);
			return "user/findid_success";
		} else {
			result.reject("userNotFound", "�ش� ������ ���� ����ڸ� ã�� �� �����ϴ�.");
			return "user/find_id";
		}
	}
	/* ��й�ȣ ã�� */
	@GetMapping("/find_pw")
	public String findPwForm(@ModelAttribute("FindPwBean") FindPwUserBean findPwBean) {
		return "user/find_pw";
	}
	
	@PostMapping("/find_pw_pro")
	public String findPwSubmit(@Valid @ModelAttribute("FindPwBean") FindPwUserBean findPwBean, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "user/find_pw";
		}
		
		String user_pw = userService.findUserPassword(findPwBean.getUser_id(), findPwBean.getUser_name(), findPwBean.getEmail());
		if (user_pw != null) {
			model.addAttribute("user_pw", user_pw);
			return "user/findpw_success";
		} else {
			result.reject("userNotFound", "�ش� ������ ���� ����ڸ� ã�� �� �����ϴ�.");
			return "user/find_pw";
		}
	}
	
	//���������� ȸ������
    @GetMapping("/modify")
    public String modify(@ModelAttribute("modifyUserBean") UserBean modifyUserBean, BindingResult result, HttpSession session) {
        LoginUserBean loggedInUser = (LoginUserBean) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            UserBean userBean = userService.getModifyUserInfo(loggedInUser);
            modifyUserBean.setUser_id(userBean.getUser_id());
            modifyUserBean.setUser_nickname(userBean.getUser_nickname());
            modifyUserBean.setUser_name(userBean.getUser_name());
            modifyUserBean.setUser_pw(userBean.getUser_pw());
            modifyUserBean.setAddress(userBean.getAddress());
            modifyUserBean.setDetailaddress(userBean.getDetailaddress());
            modifyUserBean.setAddressnum(userBean.getAddressnum());
            modifyUserBean.setAddress(userBean.getAddress());
            modifyUserBean.setPhone(userBean.getPhone());
            modifyUserBean.setEmail(userBean.getEmail());
        }
        return "user/modify";
    }
	
    //�α׾ƿ� �� ���� ��ȿ
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // ���� ��ȿȭ
        return "user/logout"; // �α׾ƿ� �� �α׾ƿ� �������� �̵�
    }
    
    //�α��� ���� Ȱ���� �α��� �������� **********����**************
    @GetMapping("/not_login")
    public String not_login() {
        return "user/login";
    }
	

	   
	  
	

	   
	   // ��ȿ�� �˻縦 ���� �ʿ��� :  Validator�� ����ϴ� ����
	   @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        binder.addValidators(new UserValidator());
	    }
	
	
	
} // main
