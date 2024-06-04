package kr.co.soldesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.soldesk.beans.BoardInfoBean;
import kr.co.soldesk.dao.TopMenuDAO;

@Service
public class TopMenuService {
	
	@Autowired
	private TopMenuDAO topMenuDAO;
	
	public List<BoardInfoBean> getTopMenuList(){
		List<BoardInfoBean> topMenuList = topMenuDAO.getTopMenuList();
		return topMenuList; // select의 결과값이 넘어옴
	} // method
	
} // class
