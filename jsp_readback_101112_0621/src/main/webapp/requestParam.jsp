<%@ page import="java.util.Arrays" %>
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
		String name, id, passwd, major, protocol;
		String[] hobby;
	%>
	
	<%
		request.setCharacterEncoding("EUC_KR");
	
		name = request.getParameter("name");
		id = request.getParameter("id");
		passwd = request.getParameter("passwd");
		major = request.getParameter("major");
		
		hobby = request.getParameterValues("hobby");
	%>
	
	�̸�&nbsp;:&nbsp<%= name %><br />
	���̵�&nbsp;:&nbsp<%= id %><br />
	��й�ȣ&nbsp;:&nbsp<%= passwd %><br />
	���&nbsp;:&nbsp<%= Arrays.toString(hobby) %><br />
	����&nbsp;:&nbsp<%= major %><br />
	
</body>
</html>