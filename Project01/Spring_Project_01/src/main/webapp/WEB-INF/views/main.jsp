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
<script src="js/main.js"></script>
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
                         <a href="${root}board/bestSeller?page=${book.isbn}"> <!-- 베스트셀러에서 위치 상세페이지로 변경해야함 -->
                            <img src="${book.book_pic}" alt="${book.book_name}" class="book-image"></a>
                            <div class="book-details">
                                <h3>${book.book_name}</h3>
                                <hr>
                                <p>${book.book_info}</p>
                                <br>
                                <p>저자: ${book.author}</p>
                                <p>판매가: ${book.book_price}원</p>
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
            <button class="tablink" onclick="openSection(event, 'md-recommended')">축구</button>
            <div class="vertical-line "></div>
            <button class="tablink" onclick="openSection(event, 'new-releases')">야구</button>
            <div class="vertical-line"></div>
            <button class="tablink" onclick="openSection(event, 'steady-sellers')">배드민턴</button>
            <div class="vertical-line"></div>
            <button class="tablink" onclick="openSection(event, 'comics')">패션</button>
        </div>

        <div id="md-recommended" class="tabcontent">
            <div class="products">
                <c:forEach var="book" items="${recommendedBooks}">
                    <div class="product">
                        <a href="${root}board/bestSeller?page=${book.isbn}"> <!-- 베스트셀러에서 위치 상세페이지로 변경해야함 -->
                        <img src="${book.book_pic}" alt="${book.book_name}"></a>
                        <p style="font-weight: 900;">${book.book_name}</p>
                        <hr>
                        <p>저자: ${book.author}</p>
                        <p>판매가: ${book.book_price}원</p>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div id="new-releases" class="tabcontent">
            <div class="products">
                <c:forEach var="book" items="${newReleases}">
                    <div class="product">
                        <a href="${root}board/bestSeller?page=${book.isbn}"> <!-- 베스트셀러에서 위치 상세페이지로 변경해야함 -->
                        <img src="${book.book_pic}" alt="${book.book_name}"></a>
                        <p style="font-weight: 900;">${book.book_name}</p>
                         <hr>
                        <p>저자: ${book.author}</p>
                        <p>판매가: ${book.book_price}원</p>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div id="steady-sellers" class="tabcontent">
            <div class="products">
                <c:forEach var="book" items="${steadySellers}">
                    <div class="product">
                        <a href="${root}board/bestSeller?page=${book.isbn}"> <!-- 베스트셀러에서 위치 상세페이지로 변경해야함 -->
                        <img src="${book.book_pic}" alt="${book.book_name}"></a>
                        <p style="font-weight: 900;">${book.book_name}</p>
                         <hr>
                        <p>저자: ${book.author}</p>
                        <p>판매가: ${book.book_price}원</p>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div id="comics" class="tabcontent">
            <div class="products">
                <c:forEach var="book" items="${comics}">
                    <div class="product">
                        <a href="${root}board/bestSeller?page=${book.isbn}"> <!-- 베스트셀러에서 위치 상세페이지로 변경해야함 -->
                        <img src="${book.book_pic}" alt="${book.book_name}"></a>
                        <p style="font-weight: 900;">${book.book_name}</p>
                         <hr>
                        <p>저자: ${book.author}</p>
                        <p>판매가: ${book.book_price}원</p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
   


    <c:import url="/WEB-INF/views/include/bottom_info.jsp" />
</body>
</html>
