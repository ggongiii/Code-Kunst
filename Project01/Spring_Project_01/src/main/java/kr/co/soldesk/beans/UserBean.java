package kr.co.soldesk.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class UserBean {
    private int user_idx;
    
    //È¸¿ø°¡ÀÔ
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "[0-9]*")
    private String phone;

    @NotBlank
    @Size(min = 2, max = 4)
    @Pattern(regexp = "[°¡-ÆR]*")
    private String user_name;
    
    /* ´Ğ³×ÀÓ ÃÖ¼Ò 6±ÛÀÚ, ¾ÆÀÌµğ ÃÖ¼Ò 6±ÛÀÚ, ºñ¹Ğ¹øÈ£ ÃÖ¼Ò 8±ÛÀÚ, À¯Àú´Ğ³×ÀÓ ¿µ¹®´ë¼Ò¹®ÀÚ, ¾ğ´õ¹Ù±îÁö °¡´ÉÇÏ°Ô ¼öÁ¤ */
	/* ºñ¹Ğ¹øÈ£ ¿µ¹®´ë¼Ò¹®ÀÚ, ¼ıÀÚ, Æ¯¼ö¹®ÀÚ±îÁö */
    @NotBlank
    @Size(min = 6, max = 20)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_id;
    
    @NotBlank
    @Size(min = 6, max = 20)
    @Pattern(regexp = "[a-zA-Z0-9_]*")
    private String user_nickname;

    @NotBlank
    @Size(min = 8)
    @Pattern(regexp = "[a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*")
    private String user_pw;
    
    @NotBlank
    @Size(min = 8)
    @Pattern(regexp = "[a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*")
    private String user_pw2;
    
    @NotBlank
    private String addressnum;
    

	@NotBlank
    private String address;
    
    @NotBlank
    private String detailaddress;
    
    
    public String getDetailaddress() {
		return detailaddress;
	}
    
    public @NotBlank String getAddressnum() {
    	return addressnum;
    }
    
    public void setAddressnum(@NotBlank String addressnum) {
    	this.addressnum = addressnum;
    }

	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}

	//¾ÆÀÌµğ, ºñ¹Ğ¹øÈ£, ´Ğ³×ÀÓ Áßº¹°Ë»ç
    private boolean userIdExist;
    
    private boolean userEmailExist;
    
    private boolean userNicknameExist;

	public boolean isUserIdExist() {
		return userIdExist;
	}
	
	public boolean isUserEmailExist() {
		return userEmailExist;
	}
	
	public boolean isUserNicknameExist() {
		return userNicknameExist;
	}

	public void setUserIdExist(boolean userIdExist) {
		this.userIdExist = userIdExist;
	}
	
	public void setUserEmailExist(boolean userEmailExist) {
		this.userEmailExist = userEmailExist;
	}
	
	public void setUserNicknameExist(boolean userNicknameExist) {
		this.userNicknameExist = userNicknameExist;
	}

	public int getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_pw2() {
		return user_pw2;
	}

	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}