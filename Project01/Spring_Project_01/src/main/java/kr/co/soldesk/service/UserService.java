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
    
    //아이디 중복검사
    public boolean checkUserIdExist(String user_id) {
        String user_name = userDao.checkUserIdExist(user_id);
        return user_name == null;
    }
    
    //이메일 중복검사
    public boolean checkUserEmailExist(String email) {
        String user_name = userDao.checkUserEmailExist(email);
        return user_name == null;
    }
    
    //닉네임 중복검사
    public boolean checkUserNicknameExist(String user_nickname) {
        String user_name = userDao.checkUserNicknameExist(user_nickname);
        return user_name == null;
    }
    
    //회원가입시 정보 넣기
    public void addUserInfo(UserBean joinUserBean) {
        userDao.addUserInfo(joinUserBean);
    }
    
    public String findUserId(String user_name, String email, String phone) {
        // 아이디 찾기 로직
        return userDao.findUserId(user_name, email, phone);
    }

    public String findUserPassword(String user_id, String user_name, String email) {
        // 비밀번호 찾기 로직
        return userDao.findUserPassword(user_id, user_name, email);
    }
    
    //로그인시 정보 확인
    public boolean checkUser(LoginUserBean loginUserBean) {
        LoginUserBean dbUserBean = userDao.getUserInfo(loginUserBean.getUser_id());
        return dbUserBean != null && dbUserBean.getUser_pw().equals(loginUserBean.getUser_pw());
    }
    
    // 수정된 메서드: UserBean을 반환하고, LoginUserBean을 인자로 받음
    public UserBean getModifyUserInfo(LoginUserBean loginUserBean) {
        return userDao.getModifyUserInfo(loginUserBean.getUser_id());
    }
    
    //정보수정 메서드
    public void modifyUserInfo(UserBean modifyUserBean) {
        userDao.modifyUserInfo(modifyUserBean);
    }
}
