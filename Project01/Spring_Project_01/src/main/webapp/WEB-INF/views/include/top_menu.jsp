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
        <ul class="navbar-nav">
            <c:choose>
                <c:when test="${not empty sessionScope.loggedInUser and sessionScope.loggedInUser.userLogin == true}">
                    <li class="nav-item"><a href="${root}user/modify" class="nav-link">마이페이지</a></li>
                    <li class="nav-item"><a href="${root}user/logout" class="nav-link">로그아웃</a></li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item"><a href="${root}user/login" class="nav-link">로그인</a></li>
                    <li class="nav-item"><a href="${root}user/join" class="nav-link">회원가입</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>

<!-- 검색 바 -->

		
	

<div class="search-bar">
<a href="${root}"
				class="nav-link">
<img src="${root}image/logo.png" alt="로고" class="logo"></a>
	<form action="#">
		<input type="text" placeholder="통합검색"> <input type="submit"
			value="검색">
	</form>
</div>

<!-- 네비게이션 메뉴 -->
<div class="nav-menu">
		<c:forEach var='obj' items="${topMenuList}">
		
				<a href="${root}board/page?=${obj.board_info_idx}"> ${obj.board_info_name}</a>
				
	
		</c:forEach>
</div>



<%-- 	<a href="${root}board/bestSeller">베스트셀러</a> 
	<a href="${root}board/viewpage">신간도서</a> 
	<a href="${root}board/viewpage">게시판</a> --%>

</body>




