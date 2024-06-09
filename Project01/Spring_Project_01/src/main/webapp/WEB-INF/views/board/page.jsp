<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!---- CSS영역 ---->
<!-- 탑메뉴css -->
<link href="../css/top_menu.css" rel="stylesheet" type="text/css" />
<!-- 메인메뉴css -->
<link href="../css/main.css" rel="stylesheet" type="text/css" />
<!-- 사이드바css -->
<link href="../css/sidebar.css" rel="stylesheet" type="text/css" />

<link href="../css/bottom.css" rel="stylesheet" type="text/css" />
<!-- 페이지css -->
<link href="../css/page.css" rel="stylesheet" type="text/css" />

<!-- ---------- -->

<title>page</title>
</head>
<body>

   <!-- top_menu -->
   <c:import url="/WEB-INF/views/include/top_menu.jsp" />
   
   <div class="main-container">
      <div class="content">
         <!-- 베스트셀러 섹션 -->
         <div class="bestseller-section">
            <h2>월간 베스트셀러</h2>
           
            <div class="book-list">
            
	            <c:forEach var="book" items="${bookList}">
	            <c:if test="${book.book_category == '54708'}">
	               <div class="book-item">
	               <a href="board/bookDetail?bookId=${book.book_id}">
	                  <img src="${book.book_pic}" alt="${book.book_name}" class="book-image"></a>
	                  <div class="book-details">
	                     <p style="font-weight: bolder;">${book.book_name}</p>
	                  	 <hr>
	                     <p>판매가: <span class="book-price">${book.book_price}</span>원 (${book.author}) </p>
	                     <br>
	                     <p>${book.book_info}</p>  
	                  </div>
	               </div>
	               </c:if>
	            </c:forEach>	         
            </div>
         </div>
      </div>
   </div>
   
   
   
      <!-- 사이드바 -->
      <c:import url="/WEB-INF/views/include/sideBar.jsp" />             
      <c:import url="/WEB-INF/views/include/bottom_info.jsp" />  
               
               <!-- 더 많은 책 아이템 추가 -->
            
         
   

</body>
</html>
