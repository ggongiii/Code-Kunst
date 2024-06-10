package kr.co.soldesk.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.soldesk.beans.BoardInfoBean;
import kr.co.soldesk.beans.LoginUserBean;
import kr.co.soldesk.dao.TopMenuDAO;
import kr.co.soldesk.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor {

	// Interceptor 처리된 클래스에서는 @Autowired를 사용할 수 없다
	private TopMenuService topMenuService;
	private LoginUserBean loginUserBean; 

	//DI
		public TopMenuInterceptor(TopMenuService topMenuService, LoginUserBean loginUserBean) {
			this.topMenuService=topMenuService;
			this.loginUserBean=loginUserBean;
			
		}

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			List<BoardInfoBean> topMenuList=topMenuService.getTopMenuList();
			request.setAttribute("topMenuList", topMenuList);
			request.setAttribute("loginUserBean", loginUserBean);
			return HandlerInterceptor.super.preHandle(request, response, handler);
		}

	}