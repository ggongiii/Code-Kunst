package kr.co.soldesk.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.soldesk.beans.LoginUserBean;
import kr.co.soldesk.beans.UserBean;

public interface UserMapper {
    
	//아이디 중복검사
    @Select("SELECT user_id FROM user_info WHERE user_id = #{user_id}")
    String checkUserIdExist(String user_id);
    
    //이메일 중복검사
    @Select("SELECT email FROM user_info WHERE email = #{email}")
    String checkUserEmailExist(String email);
    
    //닉네임 중복검사
    @Select("SELECT user_nickname FROM user_info WHERE user_nickname = #{user_nickname}")
    String checkUserNicknameExist(String user_nickname);
    
    //회원가입시 db에 들어감
    @Insert("INSERT INTO user_info (user_idx, user_name, user_id, user_pw, email, user_nickname, phone, address, detailaddress, addressnum) " +
            "VALUES (user_seq.nextval, #{user_name}, #{user_id}, #{user_pw}, #{email}, #{user_nickname}, #{phone}, #{address}, #{detailaddress}, #{addressnum})")
    void addUserInfo(UserBean joinUserBean);
    
    //로그인 시 db의 정보 확인
    @Select("SELECT user_id, user_pw FROM user_info WHERE user_id = #{user_id}")
    LoginUserBean getUserInfo(String user_id);
    
    //아이디 찾기
    @Select("SELECT user_id FROM user_info WHERE user_name = #{user_name} AND email = #{email} AND phone = #{phone}")
    String findUserId(@Param("user_name") String user_name, @Param("email") String email, @Param("phone") String phone);
    
    //비밀번호 찾기
    @Select("SELECT user_pw FROM user_info WHERE user_id = #{user_id} AND user_name = #{user_name} AND email = #{email}")
    String findUserPassword(@Param("user_id") String user_id, @Param("user_name") String user_name, @Param("email") String email);
    
    //마이페이지 정보 확인
    @Select("SELECT * FROM user_info WHERE user_id = #{user_id}")
    UserBean getModifyUserInfo(String user_id);
    
    //정보 수정
    @Update("UPDATE user_info SET user_pw = #{user_pw}, user_nickname = #{user_nickname}, address = #{address}, detailaddress=#{detailaddress} WHERE user_id = #{user_id}")
    void modifyUserInfo(UserBean modifyUserBean);
}
