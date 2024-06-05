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
		<br>	<br>	<br>
		<!-- 큐레이팅 추천제품 -->
		<div class="products">
			
			<h2 style=>이번 달 베스트 셀러</h2>
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
				
			</div>
			<button class="btn next" onclick="slide(1, 'products')">&gt;</button>
		</div>
	</div>
<!-- --------------------	하단메뉴바 ----------------------------->
	
	
	

        <!-- 메뉴바 -->
        
        	<h2 style="text-align: center;">취미에 맞는책</h2>
        <div class="menu-bar">
       	
            <button class="tablink" onclick="openSection(event, 'md-recommended')">축구</button>
            <button class="tablink" onclick="openSection(event, 'new-releases')">야구</button>
            <button class="tablink" onclick="openSection(event, 'steady-sellers')">배드민턴</button>
            <button class="tablink" onclick="openSection(event, 'comics')">패션</button>
        </div>


        <div id="md-recommended" class="tabcontent">
            <div class="products">
                <div class="products-inner">
                    <div class="product">
                        <a href="link1"><img src="image/sample_450.jpg" alt="MD 추천도서1"></a>
                        <p>12121121212</p>
                    </div>
                    <div class="product">
                        <a href="link2"><img src="image/sample_450.jpg" alt="MD 추천도서2"></a>
                        <p>123221321323</p>
                    </div>
                    <div class="product">
                        <a href="link3"><img src="image/sample_450.jpg" alt="MD 추천도서3"></a>
                        <p>12331232132323</p>
                    </div>
                </div>
            </div>
        </div>

        <div id="new-releases" class="tabcontent">
            <div class="products">
                <div class="products-inner">
                    <div class="product">
                        <a href="link5"><img src="image/sample_450.jpg" alt="신간도서1"></a>
                        <p>12331232132323</p>
                    </div>
                    <div class="product">
                        <a href="link6"><img src="image/sample_450.jpg" alt="신간도서2"></a>
                        <p>12331232132323</p>
                    </div>
                    <div class="product">
                        <a href="link7"><img src="image/sample_450.jpg" alt="신간도서3"></a>
                        <p>12331232132323</p>
                    </div>
                </div>
            </div>
        </div>


        <div id="steady-sellers" class="tabcontent">
            <div class="products">
                <div class="products-inner">
                    <div class="product">
                        <a href="link9"><img src="image/sample_450.jpg" alt="스테디셀러1"></a>
                        <p>12331232132323</p>
                    </div>
                    <div class="product">
                        <a href="link10"><img src="image/sample_450.jpg" alt="스테디셀러2"></a>
                        <p>12331232132323</p>
                    </div>
                    <div class="product">
                        <a href="link11"><img src="image/sample_450.jpg" alt="스테디셀러3"></a>
                        <p>12331232132323</p>
                    </div>
                </div>
            </div>
        </div>

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
    

	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />
</body>
</html>

