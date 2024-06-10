package kr.co.soldesk.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.soldesk.beans.UserBean;
import kr.co.soldesk.beans.LoginUserBean;
import kr.co.soldesk.beans.FindIdUserBean;
import kr.co.soldesk.beans.FindPwUserBean;

public class UserValidator implements Validator{
	
	
    @Override
    public boolean supports(Class<?> clazz) {
        // UserBean, LoginUserBean, FindIdUserBean, FindPwUserBean 모두 지원
        return UserBean.class.isAssignableFrom(clazz) ||
               LoginUserBean.class.isAssignableFrom(clazz) ||
               FindIdUserBean.class.isAssignableFrom(clazz) ||
               FindPwUserBean.class.isAssignableFrom(clazz);
    }
    
    //비밀번호 확인
    @Override
    public void validate(Object target, Errors errors) {
        if (target instanceof UserBean) {
            UserBean userBean = (UserBean) target; // 형 변환
            if (!userBean.getUser_pw().equals(userBean.getUser_pw2())) {
                errors.rejectValue("user_pw", "NotEquals");
                errors.rejectValue("user_pw2", "NotEquals");
            }
            
            //아이디, 비밀번호, 닉네임 중복확인
            if (!userBean.isUserIdExist()) {
                errors.rejectValue("user_id", "DontCheckUserIdExist");
            }if(!userBean.isUserEmailExist()){
            	errors.rejectValue("email", "DontCheckUserEmailExist");
            }if(!userBean.isUserNicknameExist()) {
            	errors.rejectValue("user_nickname", "DontCheckUserNicknameExist");
            }
            //로그인시 공백 없이
        } else if (target instanceof LoginUserBean) {
            LoginUserBean loginUserBean = (LoginUserBean) target; // 형 변환
            if (loginUserBean.getUser_id() == null || loginUserBean.getUser_id().isEmpty()) {
                errors.rejectValue("user_id", "required");
            }
            if (loginUserBean.getUser_pw() == null || loginUserBean.getUser_pw().isEmpty()) {
                errors.rejectValue("user_pw", "required");
            }
            
			/* 아이디, 비밀번호 찾기 유효성 검사 추가 */
            
        } else if (target instanceof FindIdUserBean) {
            FindIdUserBean findIdUserBean = (FindIdUserBean) target; // 형 변환
            if (findIdUserBean.getUser_name() == null || findIdUserBean.getUser_name().isEmpty()) {
                errors.rejectValue("user_name", "required");
            }
            if (findIdUserBean.getEmail() == null || findIdUserBean.getEmail().isEmpty()) {
                errors.rejectValue("email", "required");
            }
            if (findIdUserBean.getPhone() == null || findIdUserBean.getPhone().isEmpty()) {
                errors.rejectValue("phone", "required");
            }
        } else if (target instanceof FindPwUserBean) {
            FindPwUserBean findPwUserBean = (FindPwUserBean) target; // 형 변환
            if (findPwUserBean.getUser_id() == null || findPwUserBean.getUser_id().isEmpty()) {
                errors.rejectValue("user_id", "required");
            }
            if (findPwUserBean.getUser_name() == null || findPwUserBean.getUser_name().isEmpty()) {
                errors.rejectValue("user_name", "required");
            }
            if (findPwUserBean.getEmail() == null || findPwUserBean.getEmail().isEmpty()) {
                errors.rejectValue("email", "required");
            }
        }
    }
}