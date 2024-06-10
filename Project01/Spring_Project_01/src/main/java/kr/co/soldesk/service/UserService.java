package kr.co.soldesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.soldesk.beans.LoginUserBean;
import kr.co.soldesk.beans.UserBean;
import kr.co.soldesk.dao.UserDao;

@Service
public class UserService {
    
    @Autowired
    private UserDao userDao;
    
    //���̵� �ߺ��˻�
    public boolean checkUserIdExist(String user_id) {
        String user_name = userDao.checkUserIdExist(user_id);
        return user_name == null;
    }
    
    //�̸��� �ߺ��˻�
    public boolean checkUserEmailExist(String email) {
        String user_name = userDao.checkUserEmailExist(email);
        return user_name == null;
    }
    
    //�г��� �ߺ��˻�
    public boolean checkUserNicknameExist(String user_nickname) {
        String user_name = userDao.checkUserNicknameExist(user_nickname);
        return user_name == null;
    }
    
    //ȸ�����Խ� ���� �ֱ�
    public void addUserInfo(UserBean joinUserBean) {
        userDao.addUserInfo(joinUserBean);
    }
    
    public String findUserId(String user_name, String email, String phone) {
        // ���̵� ã�� ����
        return userDao.findUserId(user_name, email, phone);
    }

    public String findUserPassword(String user_id, String user_name, String email) {
        // ��й�ȣ ã�� ����
        return userDao.findUserPassword(user_id, user_name, email);
    }
    
    //�α��ν� ���� Ȯ��
    public boolean checkUser(LoginUserBean loginUserBean) {
        LoginUserBean dbUserBean = userDao.getUserInfo(loginUserBean.getUser_id());
        return dbUserBean != null && dbUserBean.getUser_pw().equals(loginUserBean.getUser_pw());
    }
    
    // ������ �޼���: UserBean�� ��ȯ�ϰ�, LoginUserBean�� ���ڷ� ����
    public UserBean getModifyUserInfo(LoginUserBean loginUserBean) {
        return userDao.getModifyUserInfo(loginUserBean.getUser_id());
    }
    
    //�������� �޼���
    public void modifyUserInfo(UserBean modifyUserBean) {
        userDao.modifyUserInfo(modifyUserBean);
    }
}
