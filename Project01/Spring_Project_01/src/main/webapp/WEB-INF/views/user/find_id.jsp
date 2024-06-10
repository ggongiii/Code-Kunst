<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>아이디 찾기</title>
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
        .top-menu {
            width: 100%;
            text-align: left;
            margin-bottom: 20px;
        }
        .bottom-menu {
            width: 100%;
            text-align: left;
            margin-top: 20px;
        }
        .error-message {
        font-size: 12px; /* 원하는 폰트 사이즈로 변경 */
        color: red; /* 에러 메시지 색상 (필요에 따라 변경 가능) */
    }
</style>
<link href="${root}/resources/css/top_menu.css" rel="stylesheet" type="text/css" />

<!-- Bootstrap CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="top-menu">
    <c:import url="/WEB-INF/views/include/top_menu.jsp"></c:import>
</div>

<div class="container" style="margin-top: 50px">
    <h1 class="text-center">사이트명</h1>
    <h2 class="text-center">아이디 찾기</h2>
    <form:form action="${root}user/find_id_pro" method="post" modelAttribute="FindIdBean">
        <div class="form-group">
            <form:label path="user_name"></form:label>
            <form:input path="user_name" class="form-control" placeholder="이름"/>
            <form:errors path="user_name" cssClass="error-message" style='color:red' />
        </div>
        <div class="form-group">
            <form:label path="email"></form:label>
            <form:input path="email" class="form-control" placeholder="이메일"/>
            <form:errors path="email" cssClass="error-message" style='color:red' />
            
        </div>
        <div class="form-group">
            <form:label path="phone"></form:label>
            <form:input path="phone" class="form-control" placeholder="전화번호"/>
            <form:errors path="phone"  cssClass="error-message" style='color:red' />
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-submit">아이디 찾기</button>
        </div>
        <div class="login-link">
                계정이 있으신가요? <a href="${root}user/login">로그인</a>
            </div>
        <div class="find-link">
             <a href="${root}/user/find_pw">비밀번호 찾기</a>
        </div>
    </form:form>
</div>

<div class="bottom-menu">
    <c:import url="/WEB-INF/views/include/bottom_info.jsp"></c:import>
</div>

</body>
</html>
