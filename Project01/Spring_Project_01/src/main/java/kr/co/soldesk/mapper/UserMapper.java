package kr.co.soldesk.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.soldesk.beans.UserBean;

public interface UserMapper {
	//���̵� �ߺ�üũ�� ���� sql
	@Select("Select user_name "
			+"from user_table "
			+"where user_id=#{user_id}")
	String checkUserIdExist(String user_id);
	
	
	@Insert("insert into user_table (user_idx, user_name, user_id, user_pw) " +
			"values (user_seq.nextval, #{user_name}, #{user_id}, #{user_pw})")
	void addUserInfo(UserBean joinUserBean);
}

	//ȸ������(����)
	