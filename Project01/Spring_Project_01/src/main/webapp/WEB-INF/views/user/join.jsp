<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원가입</title>
<link href="${root}/resources/css/top_menu.css" rel="stylesheet" type="text/css" />
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                document.getElementById("extraAddress").value = extraAddr;
            } else {
                document.getElementById("extraAddress").value = '';
            }

            // 디버깅을 위해 콘솔에 출력
            console.log("우편번호: " + data.zonecode);
            console.log("주소: " + addr);

            document.getElementById('addressnum').value = data.zonecode;
            document.getElementById("address").value = addr;
            document.getElementById("detailaddress").focus();
        }
    }).open();
}
</script>

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
            width: 300px;
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
        
        .error-message {
            font-size: 12px;
            color: red;
        }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script>

    // 아이디 중복확인 ajax
    function checkUserIdExist(){
        var user_id=$("#user_id").val();
        
        if(user_id.length==0){
            alert('아이디를 입력해주세요');
            return;
        }
        
        $.ajax({
            url: '${root}user/checkUserIdExist/' + user_id,
            type : 'get', 
            dataType:'text',
            success:function(result){
                if(result.trim() == 'true'){
                   alert('사용할 수 있는 아이디입니다');
                   $("#userIdExist").val('true');
                } else if(result.trim() == 'false'){
                   alert('사용할 수 없는 아이디 입니다');
                   $("#userIdExist").val('false');
                }
            }
        });
    }

    // 닉네임 중복확인 ajax
    function checkUserNicknameExist(){
        var user_nickname=$("#user_nickname").val();
        
        if(user_nickname.length==0){
            alert('닉네임을 입력해주세요');
            return;
        }
        
        $.ajax({
            url: '${root}user/checkUserNicknameExist/' + user_nickname,
            type : 'get', 
            dataType:'text',
            success:function(result){
                if(result.trim() == 'true'){
                   alert('사용할 수 있는 닉네임입니다');
                   $("#userNicknameExist").val('true');
                } else if(result.trim() == 'false'){
                   alert('사용할 수 없는 닉네임 입니다');
                   $("#userNicknameExist").val('false');
                }
            }
        });
    }
    
    // 이메일 중복확인 ajax
    function checkUserEmailExist(){
        var email=$("#email").val();
        
        if(email.length==0){
            alert('이메일을 입력해주세요');
            return;
        }
        
        $.ajax({
            url: '${root}user/checkUserEmailExist/' + email,
            type : 'get', 
            dataType:'text',
            success:function(result){
                if(result.trim() == 'true'){
                   alert('사용할 수 있는 이메일입니다');
                   $("#userEmailExist").val('true');
                } else if(result.trim() == 'false'){
                   alert('사용할 수 없는 이메일 입니다');
                   $("#userEmailExist").val('false');
                }
            }
        });
    }

    function resetUserIdExist(){
        $("#userIdExist").val('false');
    }
    function resetUserEmailExist(){
        $("#userEmailExist").val('false');
    }
    function resetUserNicknameExist(){
        $("#userNicknameExist").val('false');
    }
</script>
</head>
<body>

    <div class="container" style="margin-top: 50px">
        <h1 class="text-center">사이트명</h1>
        <h2 class="text-center">회원가입</h2>
        <form:form action="${root}user/join_pro" method="post" modelAttribute="joinUserBean">
            <form:hidden path="userIdExist" id="userIdExist"/>
            <form:hidden path="userEmailExist" id="userEmailExist"/>
            <form:hidden path="userNicknameExist" id="userNicknameExist"/>

            <div class="form-group">
                <form:input path="email" class='form-control' onkeypress="resetUserEmailExist()" placeholder="이메일 주소" />
                <button type="button" class="btn btn-primary" onclick="checkUserEmailExist()">중복확인</button>
                <form:errors path="email" cssClass="error-message" />
            </div>

            <div class="form-group">
                <form:input path="phone" class='form-control' placeholder="휴대폰 번호 (-제외)" />
                <form:errors path="phone"  cssClass="error-message" />
            </div>

            <div class="form-group">
                <form:input path="user_name" class='form-control' placeholder="성명" />
                <form:errors path="user_name" cssClass="error-message" />
            </div>

            <div class="form-group">
                <form:input path="user_id" class='form-control' onkeypress="resetUserIdExist()" placeholder="사용자 ID" />
                <button type="button" class="btn btn-primary" onclick="checkUserIdExist()">중복확인</button>
                <form:errors path="user_id" cssClass="error-message" />
            </div>

            <div class="form-group">
                <form:input path="user_nickname" class='form-control' onkeypress="resetUserNicknameExist()" placeholder="유저 닉네임" />
                <button type="button" class="btn btn-primary" onclick="checkUserNicknameExist()">중복확인</button>
                <form:errors path="user_nickname" cssClass="error-message" />
            </div>

            <div class="form-group">
                <form:password path="user_pw" class='form-control' placeholder="비밀번호" />
                <form:errors path="user_pw" cssClass="error-message" />
            </div>

            <div class="form-group">
                <form:password path="user_pw2" class='form-control' placeholder="비밀번호 확인" />
                <form:errors path="user_pw2" cssClass="error-message" />
            </div>

			<div class="form-group">
				<form:input path="addressnum" class='form-control' id="addressnum"
					placeholder="우편번호"/>
				<input type="button" class="btn btn-primary"
					onclick="sample6_execDaumPostcode()" value="우편번호 찾기" readonly="readonly">
			</div>
			<div class="form-group">
				<form:input path="address" class='form-control' id="address"
					placeholder="주소" readonly="readonly" />
			</div>
			<div class="form-group">
				<form:input path="detailaddress" class='form-control'
					id="detailaddress" placeholder="상세주소" />
			</div>


			<div class="form-group">
                <button type="submit" class="btn btn-submit">가입</button>
            </div>
            <div class="login-link">
                계정이 있으신가요? <a href="${root}user/login">로그인</a>
            </div>
        </form:form>
    </div>

</body>
</html>
