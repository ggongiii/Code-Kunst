<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f7f7f7;
        }
        .container {
            width: 300px;
            margin: 0 auto;
            text-align: center;
            padding-top: 100px;
            border : 1px solid #CCC;
            border-radius: 6px;
            margin: 50px auto;
   			padding: 20px;
   			background-color: #fff;
            /* font:    */
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
        }
        .btn-submit {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: 1px solid #4CAF50;
            border-radius: 6px;
            width: 100%;
            cursor: pointer;
            
        }
        .login-link {
            margin-top: 15px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>사이트명</h1>
        <h3>회원가입</h3>
        <form action="Registerjoin1.jsp" method="post">
            <div class="form-group">
                <input type="text" name="email" placeholder="이메일 주소" required>
            </div>
            <div class="form-group">
                <input type="text" name="phone" placeholder="휴대폰 번호" required>
            </div>
            <div class="form-group">
                <input type="text" name="username" placeholder="성명" required>
            </div>
            <div class="form-group">
                <input type="text" name="userid" placeholder="사용자 ID" required>
            </div>
            <div class="form-group">
                <input type="text" name="nickname" placeholder="유저 닉네임" required>
            </div>
            <div class="form-group">
                <input type="password" name="password" placeholder="비밀번호" required>
            </div>
            <div class="form-group">
                <input type="text" name="address" placeholder="주소" required>
            </div>
            <button type="submit" class="btn-submit" onclick="location='LoginForm.jsp'">가입</button>
        </form>
        <div class="login-link">
            <p>계정이 있으신가요? <a href="LoginForm.jsp">로그인</a></p>
        </div>
    </div>
</body>
</html>
