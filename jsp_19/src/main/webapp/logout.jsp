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
		out.print("�α׾ƿ��մϴ� : ���� ��ü ����");
		session.invalidate();
	%>
	<form action="login.html" method="post">
		<input type="submit" name="submit" value="�ٽ� �α����ϱ�"><br>
	</form>
</body>
</html>