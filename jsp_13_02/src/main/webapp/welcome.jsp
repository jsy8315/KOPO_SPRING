<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�α��� ���� ������</h1>
	<%
		Cookie[] cookies = request.getCookies();
		
		for(int i = 0; i < cookies.length; i++) {
			String id = cookies[i].getValue();
			if (id.equals("tester")) 
				out.println(id + "�� �ȳ��ϼ���" + "<br />");
		}
		
		for(int i = 0; i < cookies.length; i++) {
			String pw = cookies[i].getValue();
			if (pw.equals("1234")) 
				out.println("����� ��й�ȣ�� �׳� �ÿ��ϰ� �����ϰڽ��ϴ�: " + pw + "<br />");
		}
		
		for(int i = 0; i < cookies.length; i++) {
			out.print("cookie�� ��ȣ: " + (i + 1) + "<br />");
			out.print("cookie�� name: " + cookies[i].getName() + "<br />");
			out.print("cookie�� value: " + cookies[i].getValue() + "<br />");
		}
	%>
	<a href="logout.jsp">�α׾ƿ�</a>
</body>
</html>