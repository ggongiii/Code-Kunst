<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>책 상세 페이지</title>
<link href="../css/top_menu.css" rel="stylesheet" type="text/css" />
<link href="../css/main.css" rel="stylesheet" type="text/css" />
<link href="../css/sidebar.css" rel="stylesheet" type="text/css" />
<link href="../css/bottom.css" rel="stylesheet" type="text/css" />
<style>
    .book-detail-container {
        display: flex;
        margin-top: 30px;
    }
    .book-image-detail {
        width: 250px;
        height: auto;
    }
    .book-details {
        margin-left: 30px;
    }
    .book-details > h1 {
        font-weight: bold;
        text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.5);
    }
    .purchase-options {
        margin-left: 50px;
        background: #e3f0f8;    
        align-self: center;
        padding: 30px;
    }
    .purchase-options button {
        display: block;
        margin: 10px 0;
        width: 150px;
        height: 50px;
        font-size: 18px;
    }
    .purchase-options .cart {
        background-color: red;
        color: white;
    }
    .purchase-options .buy {
        background-color: green;
        color: white;
    }

    .recommendedBook {
        background: #f1f3f2;
        text-align: center;
        width: auto;
        margin: 10px;
        padding: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        display: flex;
        flex-wrap: wrap;
    }

    .recommendedBook .product {
        width: 200px;
        margin: 15px;
        background-color: #fff;
        padding: 8px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        text-align: center;
    }

    .recommendedBook img {
        width: 100%;
        height: auto;
    }

    .recommendedBook_detail p {
        font-weight: bolder;
        font-size: 12px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
        width: 100%;
    }
</style>
</head>
<body>
    <c:import url="/WEB-INF/views/include/top_menu.jsp" />
    
    <div class="container">
        <div class="book-detail-container">
            <div>
                <img src="${book.book_pic}" alt="${book.book_name}" class="book-image-detail">
            </div>
            <div class="book-details">
                <h1>${book.book_name}</h1>
                <p>저자: ${book.author} | 출판사: ${book.publisher}</p>
                <p>ISBN: ${book.isbn}</p>
                <hr>
                <p>판매가격: <span class="book-price">${book.book_price}</span>원</p>
                <p>배송일정: 내일 출고 가능</p>
            </div>
            <div class="purchase-options">
                <button class="cart">장바구니 담기</button>
                <button class="buy">바로구매</button>
            </div>
        </div>
    </div>
    
    <div class="container">
        <div class="book-detail-bottom">
            <div>
                <h1>도서정보</h1>
                <a>"${book.book_info}"</a>
            </div>
        </div>
    </div>
    
    <div class="container">
        <h2>추천도서</h2>
        <div class="recommendedBook">
            <c:forEach var="recommendedBook" items="${recommendedBooks}">
                <div class="product">
                    <a href="${pageContext.request.contextPath}/board/bookDetail?bookId=${recommendedBook.book_id}">
                        <img src="${recommendedBook.book_pic}" alt="${recommendedBook.book_name}" class="book-image">
                    </a>
                    <div class="recommendedBook_detail">
                        <p>${recommendedBook.book_name}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    
    <div class="container">
        <div class="youtube">
            <div>
                <h1>관련유튜브</h1>
                <iframe width="560" height="315" src="https://www.youtube.com/embed/oZS74-w719E" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </div>
        </div>
    </div>
    
    <c:import url="/WEB-INF/views/include/bottom_info.jsp" />
    <c:import url="/WEB-INF/views/include/sideBar.jsp" />
</body>
</html>
