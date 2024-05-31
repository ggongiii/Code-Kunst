<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
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
            text-align: center;
            padding: 20px;
            border: 1px solid #CCC;
            border-radius: 6px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
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
        .register-link {
            padding: 15px;
            margin: -10px;
            width:100%;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>사이트명</h1>
        <h3>로그인</h3>
        <form action="LoginServlet.java" method="post">
            <div class="form-group">
                <input type="text" name="userid" placeholder="사용자ID" required>
            </div>
            <div class="form-group">
                <input type="password" name="password" placeholder="비밀번호" required>
            </div>
            <button type="submit" class="btn-submit">로그인</button>      
        </form>
        <div class="register-link">
            <p>아직 계정이 없으신가요? <a href="RegisterForm.jsp">회원가입</a></p>
        </div>
    </div>
</body>
</html>
