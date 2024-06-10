package kr.co.soldesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.soldesk.beans.LoginUserBean;

//������Ʈ �۾��� ����� �Ϲ� Bean�� �����ϴ� Ŭ����
@Configuration
public class RootAppContext {
	
	//LoginUserBean loginUserBean=new LoginUserBean();
	@Bean("loginUserBean")
	@SessionScope
	public LoginUserBean loginUserBean() {
		return new LoginUserBean();
	}

}
