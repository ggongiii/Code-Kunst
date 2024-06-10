<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>마이페이지</title>
<link href="${root}/resources/css/top_menu.css" rel="stylesheet" type="text/css" />
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
            width: 300px; /* 컨테이너 크기를 확장 */
            text-align: center;
            padding: 15px;
            border: 1px solid #CCC;
            border-radius: 6px;
            background-color: #fff;
        }
        .form-group {
            margin-bottom: 10px;
            display: flex;
            align-items: center;
        }
        .form-group input {
            flex: 1;
            padding: 5px;
            box-sizing: border-box;
        }
        .btn-primary {
            margin-left: 10px;
            padding: 5px 10px;
            font-size: 12px;
            background-color: #4CAF50;
            color: white;
            border: 1px solid #4CAF50;
            border-radius: 6px;
            cursor: pointer;
        }
        .btn-submit {
            background-color: #4CAF50;
            color: white;
            padding: 8px;
            border: 1px solid #4CAF50;
            border-radius: 6px;
            width: 100%;
            cursor: pointer;
        }
        .login-link {
            margin-top: 10px;
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
            font-size: 12px;
            color: red;
        }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

</head>
<body>


<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
					<form:form action="${root}user/modify_pro" method="post" modelAttribute="modifyUserBean">
					<div class="form-group">
                <form:label path="email"></form:label>
                <form:input path="email" class='form-control' disabled="true" placeholder="이메일 주소" />
                <form:errors path="email" cssClass="error-message" />
            </div>

            <div class="form-group">
                <form:label path="phone"></form:label>
                <form:input path="phone" class='form-control' disabled="true" placeholder="휴대폰 번호 (-제외)" />
                <form:errors path="phone"  cssClass="error-message" />
            </div>

            <div class="form-group">
                <form:label path="user_name"></form:label>
                <form:input path="user_name" class='form-control' disabled="true" placeholder="성명" />
                <form:errors path="user_name" cssClass="error-message" />
            </div>

            <div class="form-group">
                <form:label path="user_id"></form:label>
                <form:input path="user_id" class='form-control' disabled="true" placeholder="사용자 ID" />
                <form:errors path="user_id" cssClass="error-message" />
            </div>

            <div class="form-group">
                <form:label path="user_nickname"></form:label>
                <form:input path="user_nickname" class='form-control' placeholder="유저 닉네임" />
                <form:errors path="user_nickname" cssClass="error-message" />
            </div>

            <div class="form-group">
                <form:label path="user_pw"></form:label>
                <form:password path="user_pw" class='form-control' placeholder="비밀번호" />
                <form:errors path="user_pw" cssClass="error-message" />
            </div>

            <div class="form-group">
                <form:label path="user_pw2"></form:label>
                <form:password path="user_pw2" class='form-control' placeholder="비밀번호 확인" />
                <form:errors path="user_pw2" cssClass="error-message" />
            </div>

            <div class="form-group">
                <form:label path="address"></form:label>
                <form:input path="address" class='form-control' placeholder="주소" />
                <form:errors path="address" cssClass="error-message" />
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-submit">정보수정</button>
            </div>
					
					</form:form>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>


</body>
</html>
