package kr.co.soldesk.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.soldesk.beans.UserBean;

public class UserValidator implements Validator{

   @Override
   public boolean supports(Class<?> clazz) {
      return UserBean.class.isAssignableFrom(clazz);
   } // method

   @Override
   public void validate(Object target, Errors errors) {
      UserBean userBean = (UserBean) target;
      if(userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
         // 패스워드와 패스워드 확인이 서로 일치하지 않은 경우
         errors.rejectValue("user_pw", "NotEquals");
         errors.rejectValue("user_pw2", "NotEquals");
      } // if
      
      if(userBean.isUserIdExist() == false) {
          errors.rejectValue("user_id", "DontCheckUserIdExist");
       }
   } // method
   
   

} // class