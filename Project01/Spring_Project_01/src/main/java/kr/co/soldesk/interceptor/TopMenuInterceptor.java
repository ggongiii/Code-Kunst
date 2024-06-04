package kr.co.soldesk.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.soldesk.beans.BoardInfoBean;
import kr.co.soldesk.dao.TopMenuDAO;
import kr.co.soldesk.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor {

	// Interceptor ó���� Ŭ���������� @Autowired�� ����� �� ����
	private TopMenuService topMenuService;

	// DI
	public TopMenuInterceptor(TopMenuService topMenuService) {
		this.topMenuService = topMenuService;
	} // constructor

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		return true;
	} // method
	
} // class
