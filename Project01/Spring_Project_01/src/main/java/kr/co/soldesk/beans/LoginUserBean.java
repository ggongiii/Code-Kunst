package kr.co.soldesk.beans;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginUserBean {
	
	//濡쒓렇�씤 
    @NotBlank
    @Size(min = 4, max = 20)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_id;
    
    //鍮꾨�踰덊샇 �듅�닔臾몄옄源뚯�
    @NotBlank
    @Size(min = 6)
    @Pattern(regexp = "[a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*")
    private String user_pw;

    private boolean userLogin; // 濡쒓렇�씤 �뿬遺�瑜� ���옣�븷 �븘�뱶

    // Getters and Setters
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public boolean isUserLogin() {
        return userLogin;
    }

    public void setUserLogin(boolean userLogin) {
        this.userLogin = userLogin;
    }
}
