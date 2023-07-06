<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	if(session.getAttribute("ValidMem") == null) {
%>   
    <jsp:forward page="login.jsp" />
<%
	}

String name = (String)session.getAttribute("name");
String id = (String)session.getAttribute("id");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>userMain.jsp</title>
</head>
<body>
	<h1>사용자 <%= name %>님 안녕하세요.</h1><br />
	<form action="logout.jsp" method="post">
		<input type="submit" value="로그아웃"> 
		<input type="button" value="회원정보조회" onclick="javascript:window.location='userSelect.jsp'">
		<input type="button" value="회원정보수정" onclick="javascript:window.location='userModify.jsp'">
	</form>
</body>
</html>