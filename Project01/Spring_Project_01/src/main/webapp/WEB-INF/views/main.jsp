<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <div class="book-slide">
                    <div class="book-box">
                        <img src="image/sample_450.jpg" alt="책 1" class="book-image">
                        <div class="book-details">
                            <h3>책 제목 1</h3>
                            <p>저자: 저자 1</p>
                            <p>판매가: 19,800원</p>
                        </div>
                    </div>
                </div>
                <div class="book-slide">
                    <div class="book-box">
                        <img src="image/sample_450.jpg" alt="책 2" class="book-image">
                        <div class="book-details">
                            <h3>책 제목 2</h3>
                            <p>저자: 저자 2</p>
                            <p>판매가: 19,800원</p>
                        </div>
                    </div>
                </div>
                <div class="book-slide">
                    <div class="book-box">
                        <img src="image/sample_450.jpg" alt="책 3" class="book-image">
                        <div class="book-details">
                            <h3>책 제목 3</h3>
                            <p>저자: 저자 3</p>
                            <p>판매가: 19,800원</p>
                        </div>
                    </div>
                </div>
            </div>
            <button class="btn next" onclick="slide(1)">&gt;</button>
        </div>
    </div>
    
    
    <div class="container">
    <h2>취미에 맞는책</h2>
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
            <div class="product">
                <a href="link1"><img src="image/sample_450.jpg" alt="MD 추천도서1"></a>
                <p>책 제목 1</p>
                <p>저자: 저자 1</p>
                <p>판매가: 15,120원</p>
            </div>
            <div class="product">
                <a href="link2"><img src="image/sample_450.jpg" alt="MD 추천도서2"></a>
                <p>책 제목 2</p>
                <p>저자: 저자 2</p>
                <p>판매가: 15,120원</p>
            </div>
            <div class="product">
                <a href="link3"><img src="image/sample_450.jpg" alt="MD 추천도서3"></a>
                <p>책 제목 3</p>
                <p>저자: 저자 3</p>
                <p>판매가: 15,120원</p>
            </div>
        </div>
    </div>

    <div id="new-releases" class="tabcontent">
        <div class="products">
            <div class="product">
                <a href="link5"><img src="image/sample_450.jpg" alt="신간도서1"></a>
                <p>책 제목 1</p>
                <p>저자: 저자 1</p>
                <p>판매가: 16,650원</p>
            </div>
            <div class="product">
                <a href="link6"><img src="image/sample_450.jpg" alt="신간도서2"></a>
                <p>책 제목 2</p>
                <p>저자: 저자 2</p>
                <p>판매가: 16,650원</p>
            </div>
            <div class="product">
                <a href="link7"><img src="image/sample_450.jpg" alt="신간도서3"></a>
                <p>책 제목 3</p>
                <p>저자: 저자 3</p>
                <p>판매가: 16,650원</p>
            </div>
        </div>
    </div>

    <div id="steady-sellers" class="tabcontent">
        <div class="products">
            <div class="product">
                <a href="link9"><img src="image/sample_450.jpg" alt="스테디셀러1"></a>
                <p>책 제목 1</p>
                <p>저자: 저자 1</p>
                <p>판매가: 22,320원</p>
            </div>
            <div class="product">
                <a href="link10"><img src="image/sample_450.jpg" alt="스테디셀러2"></a>
                <p>책 제목 2</p>
                <p>저자: 저자 2</p>
                <p>판매가: 22,320원</p>
            </div>
            <div class="product">
                <a href="link11"><img src="image/sample_450.jpg" alt="스테디셀러3"></a>
                <p>책 제목 3</p>
                <p>저자: 저자 3</p>
                <p>판매가: 22,320원</p>
            </div>
        </div>
    </div>

    <div id="comics" class="tabcontent">
        <div class="products">
            <div class="product">
                <a href="link13"><img src="image/sample_450.jpg" alt="코믹1"></a>
                <p>책 제목 1</p>
                <p>저자: 저자 1</p>
                <p>판매가: 15,120원</p>
            </div>
            <div class="product">
                <a href="link14"><img src="image/sample_450.jpg" alt="코믹2"></a>
                <p>책 제목 2</p>
                <p>저자: 저자 2</p>
                <p>판매가: 15,120원</p>
            </div>
            <div class="product">
                <a href="link15"><img src="image/sample_450.jpg" alt="코믹3"></a>
                <p>책 제목 3</p>
                <p>저자: 저자 3</p>
                <p>판매가: 15,120원</p>
            </div>
        </div>
    </div>
    </div>

    <c:import url="/WEB-INF/views/include/bottom_info.jsp" />
</body>
</html>
