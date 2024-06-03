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
<script src="js/main.js"></script>
</head>
<body>
	<c:import url="/WEB-INF/views/include/top_menu.jsp" />

	<div class="container">
		<!-- 큐레이팅 추천제품 -->
		<div class="products">
			<h2>큐레이팅 추천 제품</h2>
			<button class="btn prev" onclick="slide(-1, 'products')">&lt;</button>
			<div class="products-inner">
				<div class="product">
					<a href="${root}board/bestSeller"><img src="image/sample_450.jpg" alt="추천도서1"></a>
					<p>추천도서 1</p>
				</div>
				<div class="product">
					<a href="${root}board/bestSeller"><img src="image/sample_450.jpg" alt="추천도서2"></a>
					<p>추천도서 2</p>
				</div>
				<div class="product">
					<a href="${root}board/bestSeller"><img src="image/sample_450.jpg" alt="추천도서3"></a>
					<p>추천도서 3</p>
				</div>
				<div class="product">
					<a href="${root}board/bestSeller"><img src="image/sample_450.jpg" alt="추천도서4"></a>
					<p>추천도서 4</p>
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
					<a href="${root}board/bestSeller"><img src="image/sample_450.jpg" alt="베스트셀러1"></a>
					<p>베스트셀러 1</p>
				</div>
				<div class="product">
					<a href="${root}board/bestSeller"><img src="image/sample_450.jpg" alt="베스트셀러2"></a>
					<p>베스트셀러 2</p>
				</div>
				<div class="product">
					<a href="${root}board/bestSeller"><img src="image/sample_450.jpg" alt="베스트셀러3"></a>
					<p>베스트셀러 3</p>
				</div>
				<div class="product">
					<a href="${root}board/bestSeller"><img src="image/sample_450.jpg" alt="베스트셀러4"></a>
					<p>베스트셀러 4</p>
				</div>
			</div>
			<button class="btn next" onclick="slide(1, 'bestseller')">&gt;</button>
		</div>
	</div>

	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />
</body>
</html>

