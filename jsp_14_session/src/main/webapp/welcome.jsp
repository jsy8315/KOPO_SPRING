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
<h1>�α��� ����</h1>
	<%
		//���� ���� ���� ���
		String sessionId = (String)session.getAttribute("sessionId");
		out.println(sessionId + "�� �ݰ����ϴ�. <br>");
		String sessionPw = (String)session.getAttribute("sessionPw");
		out.println("����� ��й�ȣ�� " +sessionPw +"�Դϴ�. <br />");
	%>
<h1>������ ��� ������ Ű�� ���� ���ͼ� ����غ�����!</h1>
	<%
		//��� ���� ���� ���
		String Is_name = "";
		String Is_value = "";
		
		Enumeration enum_all = session.getAttributeNames();
		int i = 0;
		
		while(enum_all.hasMoreElements()) {
			
			i++;
			Is_name = enum_all.nextElement().toString();
			Is_value = session.getAttribute(Is_name).toString();
			
			out.println("<br/>���� �̸�["+ i + "]:" + Is_name + "<br/>");
			out.println("<br/>���� ��["+ i + "]:" + Is_value + "<br/>");
		}
	
	%>
	<a href="logout.jsp">�α׾ƿ�</a>
</body>
</html>