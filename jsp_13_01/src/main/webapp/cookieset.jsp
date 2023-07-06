<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 생성 set 페이지</h1>
	<%
		Cookie cookie = new Cookie("cookieCitizen", "CookieKing");
		cookie.setMaxAge(60 * 60);
		response.addCookie(cookie);
	%>
	<a href="cookieget.jsp">쿠키값 확인하러 가기</a>
</body>
</html>