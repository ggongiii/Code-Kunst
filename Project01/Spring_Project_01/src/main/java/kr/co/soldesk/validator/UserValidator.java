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
        // UserBean, LoginUserBean, FindIdUserBean, FindPwUserBean ��� ����
        return UserBean.class.isAssignableFrom(clazz) ||
               LoginUserBean.class.isAssignableFrom(clazz) ||
               FindIdUserBean.class.isAssignableFrom(clazz) ||
               FindPwUserBean.class.isAssignableFrom(clazz);
    }
    
    //��й�ȣ Ȯ��
    @Override
    public void validate(Object target, Errors errors) {
        if (target instanceof UserBean) {
            UserBean userBean = (UserBean) target; // �� ��ȯ
            if (!userBean.getUser_pw().equals(userBean.getUser_pw2())) {
                errors.rejectValue("user_pw", "NotEquals");
                errors.rejectValue("user_pw2", "NotEquals");
            }
            
            //���̵�, ��й�ȣ, �г��� �ߺ�Ȯ��
            if (!userBean.isUserIdExist()) {
                errors.rejectValue("user_id", "DontCheckUserIdExist");
            }if(!userBean.isUserEmailExist()){
            	errors.rejectValue("email", "DontCheckUserEmailExist");
            }if(!userBean.isUserNicknameExist()) {
            	errors.rejectValue("user_nickname", "DontCheckUserNicknameExist");
            }
            //�α��ν� ���� ����
        } else if (target instanceof LoginUserBean) {
            LoginUserBean loginUserBean = (LoginUserBean) target; // �� ��ȯ
            if (loginUserBean.getUser_id() == null || loginUserBean.getUser_id().isEmpty()) {
                errors.rejectValue("user_id", "required");
            }
            if (loginUserBean.getUser_pw() == null || loginUserBean.getUser_pw().isEmpty()) {
                errors.rejectValue("user_pw", "required");
            }
            
			/* ���̵�, ��й�ȣ ã�� ��ȿ�� �˻� �߰� */
            
        } else if (target instanceof FindIdUserBean) {
            FindIdUserBean findIdUserBean = (FindIdUserBean) target; // �� ��ȯ
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
            FindPwUserBean findPwUserBean = (FindPwUserBean) target; // �� ��ȯ
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