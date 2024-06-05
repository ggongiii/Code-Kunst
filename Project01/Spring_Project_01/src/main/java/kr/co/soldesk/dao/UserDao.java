package kr.co.soldesk.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.soldesk.beans.UserBean;
import kr.co.soldesk.mapper.UserMapper;

@Repository
public class UserDao {
	
		
		@Autowired
		private UserMapper userMapper;
		
		
		
		public String checkUserIdExist(String user_id) {
			return userMapper.checkUserIdExist(user_id);
			//익스큐트 쿼리부분 레포지토리에 저장
		}
		
		public void addUserInfo(UserBean joinUserBean) {
			userMapper.addUserInfo(joinUserBean);
		}
		
		
		
}



