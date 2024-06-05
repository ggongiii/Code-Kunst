package kr.co.soldesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.soldesk.beans.UserBean;
import kr.co.soldesk.dao.UserDao;


@Service
public class UserService {

	@Autowired
	private UserDao userdao;

	// �Ѱܹ��� ���̵� ����Ͽ� ��ȯ ���� �̸��� �������� �Ǵ� ����
	public boolean checkUserExist(String user_id) {
		String user_name = userdao.checkUserIdExist(user_id);

		if (user_name == null) {
			return true; //��밡��
		} else { 
			return false; //�̹������ϴ� �������� 
		}
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		userdao.addUserInfo(joinUserBean);
	}
}
