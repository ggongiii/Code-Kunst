package kr.co.soldesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.soldesk.beans.UserBean;
import kr.co.soldesk.dao.UserDao;


@Service
public class UserService {

	@Autowired
	private UserDao userdao;

	// 넘겨받은 아이디를 사용하여 반환 받은 이름이 가능한지 판단 여부
	public boolean checkUserExist(String user_id) {
		String user_name = userdao.checkUserIdExist(user_id);

		if (user_name == null) {
			return true; //사용가능
		} else { 
			return false; //이미존재하는 유저네임 
		}
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		userdao.addUserInfo(joinUserBean);
	}
}
