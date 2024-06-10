<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>로그인</title>
<style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f7f7f7;
        }
        .container {
            width: 250px; /* 컨테이너 크기를 줄임 */
            text-align: center;
            padding: 15px; /* 패딩 크기를 줄임 */
            border: 1px solid #CCC;
            border-radius: 6px;
            background-color: #fff;
        }
        .form-group {
            margin-bottom: 10px; /* 텍스트박스 간의 간격을 줄임 */
        }
        .form-group input {
            width: 100%;
            padding: 5px; /* 텍스트박스 패딩 크기를 줄임 */
            box-sizing: border-box;
        }
        .btn-submit {
            background-color: #4CAF50;
            color: white;
            padding: 8px; /* 버튼 패딩 크기를 줄임 */
            border: 1px solid #4CAF50;
            border-radius: 6px;
            width: 100%;
            cursor: pointer;
        }
        .login-link {
            margin-top: 10px; /* 링크 간격을 줄임 */
        }
        .find-link {
            margin-top: 10px; /* 링크 간격을 줄임 */
            margin:10px;
            font-size: 14px;
        }
        .find-link a:first-child {
            margin-right: 25px; /* 첫 번째 링크와 두 번째 링크 사이의 간격을 추가 */
        }
    
</style>
<link href="${root}/resources/css/top_menu.css" rel="stylesheet" type="text/css" />

<!-- Bootstrap CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container" style="margin-top: 50px">
    <h1 class="text-center">사이트명</h1>
    <h2 class="text-center">로그인</h2>                             <!-- loginUserBean객체를 세션에 저장-->
    <form:form action="${root}user/login_pro" method="post" modelAttribute="loginUserBean">
        <div class="form-group">
            <form:label path="user_id"></form:label>
            <form:input path="user_id" class="form-control" placeholder="아이디"/>
        </div>
        <div class="form-group">
            <form:label path="user_pw"></form:label>
            <form:password path="user_pw" class="form-control" placeholder="비밀번호"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-submit">로그인</button>
        </div>
        
        <!-- 아이디 비밀번호 찾기 추가 -->
        <div class="find-link">
            <a href="${root}/user/find_id">아이디 찾기</a>
        
            <a href="${root}/user/find_pw">비밀번호 찾기</a>
        </div>
        <hr/>
        <div class="login-link">
            아직 계정이 없으신가요? <a href="${root}/user/join">회원가입</a>
        </div>
    </form:form>
</div>


</body>
</html>
