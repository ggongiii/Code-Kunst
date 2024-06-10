package kr.co.soldesk.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.soldesk.beans.LoginUserBean;
import kr.co.soldesk.beans.UserBean;

public interface UserMapper {
    
	//���̵� �ߺ��˻�
    @Select("SELECT user_id FROM user_info WHERE user_id = #{user_id}")
    String checkUserIdExist(String user_id);
    
    //�̸��� �ߺ��˻�
    @Select("SELECT email FROM user_info WHERE email = #{email}")
    String checkUserEmailExist(String email);
    
    //�г��� �ߺ��˻�
    @Select("SELECT user_nickname FROM user_info WHERE user_nickname = #{user_nickname}")
    String checkUserNicknameExist(String user_nickname);
    
    //ȸ�����Խ� db�� ��
    @Insert("INSERT INTO user_info (user_idx, user_name, user_id, user_pw, email, user_nickname, phone, address, detailaddress, addressnum) " +
            "VALUES (user_seq.nextval, #{user_name}, #{user_id}, #{user_pw}, #{email}, #{user_nickname}, #{phone}, #{address}, #{detailaddress}, #{addressnum})")
    void addUserInfo(UserBean joinUserBean);
    
    //�α��� �� db�� ���� Ȯ��
    @Select("SELECT user_id, user_pw FROM user_info WHERE user_id = #{user_id}")
    LoginUserBean getUserInfo(String user_id);
    
    //���̵� ã��
    @Select("SELECT user_id FROM user_info WHERE user_name = #{user_name} AND email = #{email} AND phone = #{phone}")
    String findUserId(@Param("user_name") String user_name, @Param("email") String email, @Param("phone") String phone);
    
    //��й�ȣ ã��
    @Select("SELECT user_pw FROM user_info WHERE user_id = #{user_id} AND user_name = #{user_name} AND email = #{email}")
    String findUserPassword(@Param("user_id") String user_id, @Param("user_name") String user_name, @Param("email") String email);
    
    //���������� ���� Ȯ��
    @Select("SELECT * FROM user_info WHERE user_id = #{user_id}")
    UserBean getModifyUserInfo(String user_id);
    
    //���� ����
    @Update("UPDATE user_info SET user_pw = #{user_pw}, user_nickname = #{user_nickname}, address = #{address}, detailaddress=#{detailaddress} WHERE user_id = #{user_id}")
    void modifyUserInfo(UserBean modifyUserBean);
}
