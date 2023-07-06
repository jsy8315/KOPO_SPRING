<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>로그아웃 페이지</h1>
		<%
		Cookie[] cookies = request.getCookies();
	
		for(int i = 0; i < cookies.length; i++ ) {
			if(cookies[i].getValue().equals("tester")) {
				out.println(cookies[i].getValue() + " 가 저장된 쿠키 삭제한다");
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
	%>
	<a href="loginHtml.html">로그인 페이지로 돌아가기</a>
</body>
</html>