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
		String loginId;
		String loginPasswd;
		String inputId;
		String inputPasswd;
		
	%>
	<%
		/* String loginId = request.getParameter("id");
		String loginPasswd = request.getParameter("passwd"); */
		String inputId = request.getParameter("inputId");
		String inputPasswd = request.getParameter("inputPasswd");
	%>
	
	<%
	if ((inputId.equals("tester")) && (inputPasswd.equals("1234"))) {
	
		Cookie cookieId = new Cookie("cookieId", inputId);
		cookieId.setMaxAge(60 * 60);
		response.addCookie(cookieId);
		
		/*
		��Ű�� name�� cookieId�̰�
		value���� inputId�� ����
		������� ��Ű�� response�� ž����� sendRedirect�� welcome.jsp�� ��������
		*/
		
		Cookie cookiePw = new Cookie("cookiePw", inputPasswd);
		cookiePw.setMaxAge(60 * 60);
		response.addCookie(cookiePw);
		
		response.sendRedirect("welcome.jsp");
	} else {
		response.sendRedirect("loginHtml.html");
	}
	%>
	
</body>
</html>