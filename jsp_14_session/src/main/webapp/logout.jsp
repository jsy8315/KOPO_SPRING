<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	out.println("��� ���� ������ �����Ͽ����ϴ�. <br />");
	session.invalidate();
	%>
	<a href="session.html">�α��� �������� �ٽ� �̵�</a>
</body>
</html>