<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�α׾ƿ� ������</h1>
		<%
		Cookie[] cookies = request.getCookies();
	
		for(int i = 0; i < cookies.length; i++ ) {
			if(cookies[i].getValue().equals("tester")) {
				out.println(cookies[i].getValue() + " �� ����� ��Ű �����Ѵ�");
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
	%>
	<a href="loginHtml.html">�α��� �������� ���ư���</a>
</body>
</html>