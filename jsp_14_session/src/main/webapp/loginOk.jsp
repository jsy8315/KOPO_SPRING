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
		
		String DBid = "tester"; //�α����� ���� id �̸� ����
		String DBpasswd = "1234"; //�α����� ���� pw �̸� ����
	%>
	
	<%
	if ((inputId.equals(DBid)) && (inputPasswd.equals(DBpasswd))) {
	
		//���� ����
		//�α��ο� �����ϸ� �Էµ� ���̵�, �����ȣ�� ���Ǻ����� ������
		session.setAttribute("sessionId", inputId);
		session.setAttribute("sessionPw", inputPasswd);
		
		response.sendRedirect("welcome.jsp");
	} else {
		response.sendRedirect("loginHtml.html");
	}
	%>
</body>
</html>