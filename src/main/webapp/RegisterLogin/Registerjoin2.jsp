<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registerjoin2</title>
<script>
function showWelcomeMessage() {
    alert("환영합니다!");
}
</script>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");//한글처리
%>

<jsp:useBean id="meBean" class="model.MemberDBBean">
    <jsp:setProperty name="meBean" property="*" />
</jsp:useBean>

<%
Connection conn = null;
PreparedStatement pstmt = null;
String message = null;
String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
String dbUser = "system";
String dbPw = "12345";

try {
    // 1. 오라클 드라이버 인식 (ojdbc8.jar)
    Class.forName(jdbc_driver);
    
    // 2. 오라클 접속
    conn = DriverManager.getConnection(jdbc_url, dbUser, dbPw);

    // 3. SQL 작성
    String sql = "insert into project_test (user_id, user_name, nick_name, user_pwd, address, phone, email) values (?, ?, ?, ?, ?, ?, ?)";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, meBean.getUserid());
    pstmt.setString(2, meBean.getUsername());
    pstmt.setString(3, meBean.getNickname());
    pstmt.setString(4, meBean.getPassword());
    pstmt.setString(5, meBean.getAddress());
    pstmt.setString(6, meBean.getPhone());
    pstmt.setString(7, meBean.getEmail());
    
    pstmt.executeUpdate();
    message = "데이터가 성공적으로 삽입되었습니다.";
    response.sendRedirect("LoginForm.jsp"); // 회원가입 성공시 로그인 페이지로 이동
} catch (Exception e) {
    e.printStackTrace();
    message = "데이터 삽입 중 오류가 발생했습니다: " + e.getMessage();
    session.setAttribute("error_message", message);
} finally {
    try {
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
%>
</body>
</html>
