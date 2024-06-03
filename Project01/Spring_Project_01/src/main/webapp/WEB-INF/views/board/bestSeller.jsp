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
<!-- 사이드바css -->
<link href="../css/page.css" rel="stylesheet" type="text/css" />

<!-- ---------- -->
<!-- 폰트어썸 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

<title>bestSeller</title>
</head>
<body>

	<!-- top_menu -->
	<c:import url="/WEB-INF/views/include/top_menu.jsp" />
	<div class="main-container">
		<!-- 사이드바 -->
		<c:import url="/WEB-INF/views/include/sideBar.jsp" />
		<div class="content">
			<!-- 베스트셀러 섹션 -->
			<div class="bestseller-section">
				<h2>월간 베스트셀러</h2>
				<div class="book-list">
					<div class="book-item">
						<img src="../image/sample_150.jpg" alt="책 이미지">
						<div class="book-details">
							<div class="book-title">책 제목</div>
							<div class="book-desc">책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1책 설명 1</div>
							<div class="book-price">판매가: 10,000원</div>
							<button class="cart-btn">장바구니 담기</button>
						</div>
					</div>
					<div class="book-item">
						<img src="../image/sample_150.jpg" alt="책 이미지">
						<div class="book-details">
							<div class="book-title">책 제목 1</div>
							<div class="book-desc">책 설명 1</div>
							<div class="book-price">판매가: 10,000원</div>
							<button class="cart-btn">장바구니 담기</button>
						</div>
					</div>
					<div class="book-item">
						<img src="../image/sample_150.jpg" alt="책 이미지">
						<div class="book-details">
							<div class="book-title">책 제목 1</div>
							<div class="book-desc">책 설명 1</div>
							<div class="book-price">판매가: 10,000원</div>
							<button class="cart-btn">장바구니 담기</button>
						</div>
					</div>
					<div class="book-item">
						<img src="../image/sample_150.jpg" alt="책 이미지">
						<div class="book-details">
							<div class="book-title">책 제목 1</div>
							<div class="book-desc">책 설명 1</div>
							<div class="book-price">판매가: 10,000원</div>
							<button class="cart-btn">장바구니 담기</button>
						</div>
					</div>
					<!-- 더 많은 책 아이템 추가 -->
				</div>
			</div>
		</div>
	</div>

</body>
</html>
