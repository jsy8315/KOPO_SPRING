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

		String inputId;
		String inputPasswd;
	%>
	
	<%
		String inputId = request.getParameter("inputId");
		String inputPasswd = request.getParameter("inputPasswd");
		
		String DBid = "tester"; //로그인이 허용된 id 미리 선언
		String DBpasswd = "1234"; //로그인이 허용된 pw 미리 선언
	%>
	
	<%
	if ((inputId.equals(DBid)) && (inputPasswd.equals(DBpasswd))) {
	
		//세션 생성
		//로그인에 성공하면 입력된 아이디, 비빌번호를 세션변수에 저장함
		session.setAttribute("sessionId", inputId);
		session.setAttribute("sessionPw", inputPasswd);
		
		response.sendRedirect("welcome.jsp");
	} else {
		response.sendRedirect("loginHtml.html");
	}
	%>
</body>
</html>