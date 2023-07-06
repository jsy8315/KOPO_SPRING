<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
	
		for(int i = 0; i < cookies.length; i++ ) {
			String name = cookies[i].getName();
			String value = cookies[i].getValue();
			
			if(name.equals("cookieCitizen")) {
				out.println("쿠키 삭제한다 : " + name);
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
	%>
	<a href="cookieget.jsp">쿠키값 확인하러가기</a>
</body>
</html>