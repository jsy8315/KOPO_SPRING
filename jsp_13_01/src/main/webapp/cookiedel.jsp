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
				out.println("��Ű �����Ѵ� : " + name);
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
	%>
	<a href="cookieget.jsp">��Ű�� Ȯ���Ϸ�����</a>
</body>
</html>