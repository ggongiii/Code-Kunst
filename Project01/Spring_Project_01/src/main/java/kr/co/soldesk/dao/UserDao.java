package kr.co.soldesk.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.soldesk.beans.LoginUserBean;
import kr.co.soldesk.beans.UserBean;
import kr.co.soldesk.mapper.UserMapper;

@Repository
public class UserDao {
	
	
    @Autowired
    private UserMapper userMapper;
    
    public String checkUserIdExist(String user_id) {
        return userMapper.checkUserIdExist(user_id);
    }
    
    public String checkUserEmailExist(String email) {
        return userMapper.checkUserEmailExist(email);
    }
    
    public String checkUserNicknameExist(String user_nickname) {
        return userMapper.checkUserNicknameExist(user_nickname);
    }

    public void addUserInfo(UserBean joinUserBean) {
        userMapper.addUserInfo(joinUserBean);
    }

    public String findUserId(String user_name, String email, String phone) {
        return userMapper.findUserId(user_name, email, phone);
    }

    public String findUserPassword(String user_id, String user_name, String email) {
        return userMapper.findUserPassword(user_id, user_name, email);
    }

    public UserBean getModifyUserInfo(String user_id) {
        return userMapper.getModifyUserInfo(user_id);
    }

    public void modifyUserInfo(UserBean modifyUserBean) {
        userMapper.modifyUserInfo(modifyUserBean);
    }

    public LoginUserBean getUserInfo(String user_id) {
        return userMapper.getUserInfo(user_id);
    }
}


