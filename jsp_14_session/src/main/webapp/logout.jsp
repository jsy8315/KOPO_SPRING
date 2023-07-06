<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	out.println("모든 세션 정보를 삭제하였습니다. <br />");
	session.invalidate();
	%>
	<a href="session.html">로그인 페이지로 다시 이동</a>
</body>
</html>