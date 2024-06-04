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
<!-- 사이드바css -->
<link href="css/sidebar.css" rel="stylesheet" type="text/css" />
<script src="js/main.js"></script>
</head>
<body>
	<c:import url="/WEB-INF/views/include/top_menu.jsp" />
			<!-- 사이드바 -->
		<c:import url="/WEB-INF/views/include/sideBar.jsp" />

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


<!-- --------------------	하단메뉴바 ----------------------------->
	
	 <div class="container">
        <!-- 메뉴바 -->
        <div class="menu-bar">
            <button class="tablink" onclick="openSection(event, 'md-recommended')">MD 추천도서</button>
            <button class="tablink" onclick="openSection(event, 'new-releases')">화제의 신간</button>
            <button class="tablink" onclick="openSection(event, 'steady-sellers')">스테디셀러</button>
            <button class="tablink" onclick="openSection(event, 'comics')">코믹</button>
        </div>

        <!-- MD 추천도서 -->
        <div id="md-recommended" class="tabcontent">
            <div class="products">
                <div class="products-inner">
                    <div class="product">
                        <a href="link1"><img src="image/sample_450.jpg" alt="MD 추천도서1"></a>
                        <p>고양이는 발끝 하나 까딱하기 싫어</p>
                    </div>
                    <div class="product">
                        <a href="link2"><img src="image/sample_450.jpg" alt="MD 추천도서2"></a>
                        <p>얼룩이 번쩍 영화가 되었습니다</p>
                    </div>
                    <div class="product">
                        <a href="link3"><img src="image/sample_450.jpg" alt="MD 추천도서3"></a>
                        <p>고비키초의 복수</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- 화제의 신간 도서 -->
        <div id="new-releases" class="tabcontent">
            <div class="products">
                <div class="products-inner">
                    <div class="product">
                        <a href="link5"><img src="image/sample_450.jpg" alt="신간도서1"></a>
                        <p>코믹 메이플 스토리 수학도둑 100</p>
                    </div>
                    <div class="product">
                        <a href="link6"><img src="image/sample_450.jpg" alt="신간도서2"></a>
                        <p>임소 지느러미(TURN 1)</p>
                    </div>
                    <div class="product">
                        <a href="link7"><img src="image/sample_450.jpg" alt="신간도서3"></a>
                        <p>협력의 진화: 40주년 특별기념판</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- 스테디셀러 -->
        <div id="steady-sellers" class="tabcontent">
            <div class="products">
                <div class="products-inner">
                    <div class="product">
                        <a href="link9"><img src="image/sample_450.jpg" alt="스테디셀러1"></a>
                        <p>스테디셀러 도서 1</p>
                    </div>
                    <div class="product">
                        <a href="link10"><img src="image/sample_450.jpg" alt="스테디셀러2"></a>
                        <p>스테디셀러 도서 2</p>
                    </div>
                    <div class="product">
                        <a href="link11"><img src="image/sample_450.jpg" alt="스테디셀러3"></a>
                        <p>스테디셀러 도서 3</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- 코믹 -->
        <div id="comics" class="tabcontent">
            <div class="products">
                <div class="products-inner">
                    <div class="product">
                        <a href="link13"><img src="image/sample_450.jpg" alt="코믹1"></a>
                        <p>코믹 도서 1</p>
                    </div>
                    <div class="product">
                        <a href="link14"><img src="image/sample_450.jpg" alt="코믹2"></a>
                        <p>코믹 도서 2</p>
                    </div>
                    <div class="product">
                        <a href="link15"><img src="image/sample_450.jpg" alt="코믹3"></a>
                        <p>코믹 도서 3</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />
</body>
</html>

