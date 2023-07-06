<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 성공 페이지</h1>
	<%
		Cookie[] cookies = request.getCookies();
		
		for(int i = 0; i < cookies.length; i++) {
			String id = cookies[i].getValue();
			if (id.equals("tester")) 
				out.println(id + "님 안녕하세요" + "<br />");
		}
		
		for(int i = 0; i < cookies.length; i++) {
			String pw = cookies[i].getValue();
			if (pw.equals("1234")) 
				out.println("당신의 비밀번호는 그냥 시원하게 공개하겠습니다: " + pw + "<br />");
		}
		
		for(int i = 0; i < cookies.length; i++) {
			out.print("cookie의 번호: " + (i + 1) + "<br />");
			out.print("cookie의 name: " + cookies[i].getName() + "<br />");
			out.print("cookie의 value: " + cookies[i].getValue() + "<br />");
		}
	%>
	<a href="logout.jsp">로그아웃</a>
</body>
</html>