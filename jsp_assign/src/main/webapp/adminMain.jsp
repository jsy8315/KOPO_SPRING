<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	if(session.getAttribute("ValidMem") == null) {
%>   
    <jsp:forward page="login.jsp" />
<%
	}

String sessionName = (String) session.getAttribute("name");
String sessionId = (String) session.getAttribute("id");
session.setAttribute("sessionId", sessionId); // 세션 속성으로 sessionId 설정

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>adminMain.jsp</title>
</head>
<body>
	<h1>관리자 <%= sessionName %>님 안녕하세요.</h1><br />
	<form action="logout.jsp" method="post">
		<input type="submit" value="로그아웃"> 
		<input type="button" value="회원관리" onclick="javascript:window.location='adminModify.jsp'">
	</form>
</body>
</html>