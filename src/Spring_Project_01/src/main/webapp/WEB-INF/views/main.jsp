<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>미니 프로젝트</title>
<!-- Bootstrap CDN -->
<!-- 탑메뉴css -->
<link href="css/top_menu.css" rel="stylesheet" type="text/css" />

<!-- 메인메뉴css -->
<link href="css/main.css" rel="stylesheet" type="text/css" />
<!-- JavaScript 파일 로드 -->
<script src="js/main.js"></script>

</head>
<body>
	<!-- 상단 메뉴 부분 -->
	<!-- 리액트랑 비슷한 기능 -->
	<c:import url="/WEB-INF/views/include/top_menu.jsp" />

	<!-- 메인 컨텐츠 -->
	<div class="container">
		<!-- 큐레이팅 추천제품 -->
		<div class="products">
			<h2>큐레이팅 추천 제품</h2>
			<button class="btn prev" onclick="slide(-1, 'products')">&lt;</button>
			<div class="products-inner">
				<div class="product">
					<a href="${root}user/login"><img src="https://image.aladin.co.kr/product/28884/59/coversum/s522832546_1.jpg" alt="추천도서1">
					</a><p>추천도서 1</p>
				</div>
				<div class="product">
					<a href="${root}user/login"><img src="https://image.aladin.co.kr/product/28884/59/coversum/s522832546_1.jpg" alt="추천도서1">
					</a><p>추천도서 1</p>
				</div><div class="product">
					<a href="${root}user/login"><img src="https://image.aladin.co.kr/product/28884/59/coversum/s522832546_1.jpg" alt="추천도서1">
					</a><p>추천도서 1</p>
				</div><div class="product">
					<a href="${root}user/login"><img src="https://image.aladin.co.kr/product/28884/59/coversum/s522832546_1.jpg" alt="추천도서1">
					</a><p>추천도서 1</p>
				</div>
			</div>
			<button class="btn next" onclick="slide(1, 'products')">&gt;</button>
		</div>

		<!-- 베스트셀러 -->
		<div class="products">
			<h2>베스트셀러</h2>
			<button class="btn prev" onclick="slide(-1, 'bestseller')">&lt;</button>
			<div class="products-inner">
				<div class="product">
					<a href="${root}user/login"><img src="https://image.aladin.co.kr/product/28884/59/coversum/s522832546_1.jpg" alt="추천도서1">
					</a><p>추천도서 1</p>
				</div><div class="product">
					<a href="${root}user/login"><img src="https://image.aladin.co.kr/product/28884/59/coversum/s522832546_1.jpg" alt="추천도서1">
					</a><p>추천도서 1</p>
				</div><div class="product">
					<a href="${root}user/login"><img src="https://image.aladin.co.kr/product/28884/59/coversum/s522832546_1.jpg" alt="추천도서1">
					</a><p>추천도서 1</p>
				</div>
			</div>
			<button class="btn next" onclick="slide(1, 'bestseller')">&gt;</button>
		</div>
	</div>

	<!-- 하단 정보 부분 -->
	<!-- 리액트랑 비슷한 기능 -->
	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />
	

	
</body>
</html>
