<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>미니 프로젝트</title>
<link href="css/top_menu.css" rel="stylesheet" type="text/css" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/sidebar.css" rel="stylesheet" type="text/css" />
<link href="css/bottom.css" rel="stylesheet" type="text/css" />
<script src="js/main.js"></script>
<script>


// 기본으로 첫 번째 탭 열기
document.addEventListener("DOMContentLoaded", function() {
    document.querySelector(".tablink").click();
});
</script>
</head>
<body>
    <c:import url="/WEB-INF/views/include/top_menu.jsp" />

    
    <div class="container">
        <br><br><br>
        <h2>오늘의 책</h2>
        <div class="book-slider">
            <button class="btn prev" onclick="slide(-1)">&lt;</button>
            <div class="book-slider-inner">
                <c:forEach var="book" items="${bookList}">
                    <div class="book-slide">
                        <div class="book-box">
                            <a href="board/bookDetail?bookId=${book.book_id}">
                            <img src="${book.book_pic}" alt="${book.book_name}" class="book-image"> </a>
                            <div class="book-details">
                            <p style="font-weight: bolder;">${book.book_name}</p>
                                <hr>
                                <p>판매가: <span class="book-price">${book.book_price}</span>원 (${book.author}) </p>
                                <br>
                                <p>${book.book_info}</p>                
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <button class="btn next" onclick="slide(1)">&gt;</button>
        </div>
    </div>

    <div class="container">
        <h2>취미에 맞는 책</h2>
        <div class="menu-bar">
            <button class="tablink" onclick="openSection(event, 'md-recommended')">건강</button>
            <div class="vertical-line"></div>
            <button class="tablink" onclick="openSection(event, 'new-releases')">축구</button>
            <div class="vertical-line"></div>
            <button class="tablink" onclick="openSection(event, 'steady-sellers')">일본여행</button>
            <div class="vertical-line"></div>
            <button class="tablink" onclick="openSection(event, 'comics')">서양음악</button>
        </div>

        <div id="md-recommended" class="tabcontent">
            <div class="products">
                <c:forEach var="book" items="${bookList}">
                    <c:if test="${book.book_category eq '건강'}"> <!-- 건강 -->
                        <div class="product">
                            <a href="board/bookDetail?bookId=${book.book_id}"><img src="${book.book_pic}" alt="${book.book_name}"></a>
                            <p style="font-weight: bolder;">${book.book_name}</p>
                            <hr>
                            <p>저자: ${book.author}</p>
                            <p>판매가: <span class="book-price">${book.book_price}</span>원</p>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>

        <div id="new-releases" class="tabcontent">
            <div class="products">
                <c:forEach var="book" items="${bookList}">
                    <c:if test="${book.book_category eq '축구'}"> <!-- 축구 -->
                        <div class="product">
                            <a href="board/bookDetail?bookId=${book.book_id}"><img src="${book.book_pic}" alt="${book.book_name}"></a>
                            <p style="font-weight: bolder;">${book.book_name}</p>
                            <hr>
                            <p>저자: ${book.author}</p>
                            <p>판매가: <span class="book-price">${book.book_price}</span>원</p>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>

        <div id="steady-sellers" class="tabcontent">
            <div class="products">
                <c:forEach var="book" items="${bookList}">
                    <c:if test="${book.book_category eq '일본여행'}"> <!-- 일본여행 -->
                        <div class="product">
                            <a href="board/bookDetail?bookId=${book.book_id}"><img src="${book.book_pic}" alt="${book.book_name}"></a>
                            <p style="font-weight: bolder;">${book.book_name}</p>
                            <hr>
                            <p>저자: ${book.author}</p>
                            <p>판매가: <span class="book-price">${book.book_price}</span>원</p>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>

        <div id="comics" class="tabcontent">
            <div class="products">
                <c:forEach var="book" items="${bookList}">
                    <c:if test="${book.book_category eq '서양음악'}"> <!-- 서양음악 -->
                        <div class="product">
                            <a href="board/bookDetail?bookId=${book.book_id}"><img src="${book.book_pic}" alt="${book.book_name}"></a>
                            <p style="font-weight: bolder;">${book.book_name}</p>
                            <hr>
                            <p>저자: ${book.author}</p>
                            <p>판매가: <span class="book-price">${book.book_price}</span>원</p>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>

    <c:import url="/WEB-INF/views/include/bottom_info.jsp" />
        <c:import url="/WEB-INF/views/include/sideBar.jsp" />
</body>
</html>
