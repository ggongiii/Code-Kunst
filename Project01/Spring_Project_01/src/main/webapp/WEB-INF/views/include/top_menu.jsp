<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}/" />



<body>
<div class="header">
	<div class="logo">
		<img src="" alt="로고">
	</div>
	<div id="common_lnb">
		<ul class="menu">
			<li class="nav-item"><a href="${root}user/login"
				class="nav-link">로그인</a></li>
			<li class="nav-item"><a href="${root}user/join" 
				class="nav-link">회원가입</a></li>
			<li class="nav-item"><a href="${root}user/modify"
				class="nav-link">정보수정</a></li>
			<li class="nav-item"><a href="${root}user/logout"
				class="nav-link">로그아웃</a></li>
		</ul>
	</div>
	
<%-- db연결해서 해야할것	<ul class="navbar-nav">
			<c:forEach var='obj' items="${topMenuList}">
				<li class="nav-item"><a
					href="${root}board/main?board_info_idx=${obj.board_info_idx}"
					class="nav-link">${obj.board_info_name}</a></li>
			</c:forEach>
		</ul> --%>
	
	
</div>

<!-- 검색 바 -->
<div class="search-bar">
	<form action="#">
		<input type="text" placeholder="통합검색"> <input type="submit"
			value="검색">
	</form>
</div>

<!-- 네비게이션 메뉴 -->
<div class="nav-menu">
		<c:forEach var='obj' items="${topMenuList}">
			
				<a
					href="${root}board/bestSeller?page=${obj.board_info_idx}&name=${obj.board_Info_name_en}"> ${obj.board_info_name}</a>
			
				
		</c:forEach>
</div>



<%-- 	<a href="${root}board/bestSeller">베스트셀러</a> 
	<a href="${root}board/viewpage">신간도서</a> 
	<a href="${root}board/viewpage">게시판</a> --%>

</body>




