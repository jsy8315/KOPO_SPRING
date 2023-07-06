<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!
		String id, passwd;
	%>
	
	<%
		id = request.getParameter("id");
		passwd = request.getParameter("passwd");
	%>
	
	<h1>forward_param.jsp</h1>
	아이디 : <%= id %>
	비밀번호 : <%= passwd %>
</body>
</html>