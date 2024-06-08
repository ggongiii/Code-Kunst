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
function openSection(evt, sectionName) {
    // 모든 탭 콘텐츠 숨기기
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    // 모든 탭 링크의 활성화 상태 제거
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    // 선택된 섹션 보여주기
    document.getElementById(sectionName).style.display = "block";
    evt.currentTarget.className += " active";
    
    // 첫 10개의 책만 노출
    var books = document.getElementById(sectionName).getElementsByClassName("product");
    for (i = 0; i < books.length; i++) {
        if (i < 10) {
            books[i].style.display = "block";
        } else {
            books[i].style.display = "none";
        }
    }
}

// 기본으로 첫 번째 탭 열기
document.addEventListener("DOMContentLoaded", function() {
    document.querySelector(".tablink").click();
});
</script>
</head>
<body>
    <c:import url="/WEB-INF/views/include/top_menu.jsp" />
    <c:import url="/WEB-INF/views/include/sideBar.jsp" />
    
    <div class="container">
        <br><br><br>
        <h2>오늘의 책</h2>
        <div class="book-slider">
            <button class="btn prev" onclick="slide(-1)">&lt;</button>
            <div class="book-slider-inner">
                <c:forEach var="book" items="${bookList}">
                    <div class="book-slide">
                        <div class="book-box">
                            <img src="${book.book_pic}" alt="${book.book_name}" class="book-image">
                            <div class="book-details">
                                <h3>${book.book_name}</h3>
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
                    <c:if test="${book.book_category == '55890'}"> <!-- 건강 -->
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
                    <c:if test="${book.book_category == '54708'}"> <!-- 축구 -->
                        <div class="product">
                            <a href="#"><img src="${book.book_pic}" alt="${book.book_name}"></a>
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
                    <c:if test="${book.book_category == '50832'}"> <!-- 일본여행 -->
                        <div class="product">
                            <a href="#"><img src="${book.book_pic}" alt="${book.book_name}"></a>
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
                    <c:if test="${book.book_category == '51012'}"> <!-- 서양음악 -->
                        <div class="product">
                            <a href="#"><img src="${book.book_pic}" alt="${book.book_name}"></a>
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
</body>
</html>
