package kr.co.soldesk.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.soldesk.beans.LoginUserBean;

public class CheckLoginInterceptor implements HandlerInterceptor {
	
	
	//세션 인터셉터
	//loginUserBean
    private LoginUserBean loginUserBean;

    public CheckLoginInterceptor(LoginUserBean loginUserBean) {
        this.loginUserBean = loginUserBean;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        LoginUserBean loggedInUser = (LoginUserBean) session.getAttribute("loggedInUser");

        // 로그인을 하지 않았다면
        if (loggedInUser == null || !loggedInUser.isUserLogin()) {
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/user/not_login");
            return false;
        }
        // 로그인 상태
        return true;
    }
}
