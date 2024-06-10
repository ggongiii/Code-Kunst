package kr.co.soldesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.soldesk.beans.LoginUserBean;

//프로젝트 작업시 사용할 일반 Bean들 정의하는 클래스
@Configuration
public class RootAppContext {
	
	//LoginUserBean loginUserBean=new LoginUserBean();
	@Bean("loginUserBean")
	@SessionScope
	public LoginUserBean loginUserBean() {
		return new LoginUserBean();
	}

}
