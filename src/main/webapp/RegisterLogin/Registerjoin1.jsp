<%@ page import="model.MemberDAO"%>
<%@ page import="model.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registerjoin1</title>
<script type="text/javascript">
    function showSuccessMessage() {
        alert('회원가입이 완료되었습니다.');
        window.location.href = 'LoginForm.jsp';
    }

    function showErrorMessage(message) {
        alert(message);
        history.back();
    }
</script>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8"); // 한글처리
%>

<jsp:useBean id="meBean" class="model.MemberDBBean">
    <jsp:setProperty name="meBean" property="*" />
</jsp:useBean>

<jsp:useBean id="mDAO" class="model.MemberDAO" />

<%
    String userid = meBean.getUserid();
    String username = meBean.getUsername();
    String nickname = meBean.getNickname();
    String password = meBean.getPassword();
    String address = meBean.getAddress();
    String phone = meBean.getPhone();
    String email = meBean.getEmail();

    if (userid.length()<5 || userid.length() > 20) {
        out.println("<script>showErrorMessage('아이디는 5자 이상 20자 이하로 입력해주세요.');</script>");
    } else if (username == null || username.length() > 20) {
        out.println("<script>showErrorMessage('이름은 1자 이상 20자 이하로 입력해주세요.');</script>");
    } else if (nickname.length()<5 || nickname.length() > 40) {
        out.println("<script>showErrorMessage('닉네임은 5자 이상 40자 이하로 입력해주세요.');</script>");
    } else if (password.length()<8 || password.length() > 20) {
        out.println("<script>showErrorMessage('비밀번호는 8자 이상 20자 이하로 입력해주세요.');</script>");
    } else if (address == null || address.length() > 40) {
        out.println("<script>showErrorMessage('주소는 40자 이하로 입력해주세요.');</script>");
    } else if (phone == null || phone.length() > 40) {
        out.println("<script>showErrorMessage('전화번호는 40자 이하로 입력해주세요.');</script>");
    } else if (email.length() > 40) {
        out.println("<script>showErrorMessage('이메일은 40자 이하로 입력해주세요.');</script>");
    } else if (mDAO.isIdExist(userid)) {
        out.println("<script>showErrorMessage('이미 존재하는 아이디입니다.');</script>");
    } else {
        boolean isSuccess = mDAO.insertMember(meBean);
        if (isSuccess) {
            out.println("<script>showSuccessMessage();</script>");
        } else {
            out.println("<script>showErrorMessage('" + mDAO.getMessage() + "');</script>");
        }
    }
%>
</body>
</html>
