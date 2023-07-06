<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%! int age; %>
	
	<%
		String Age = request.getParameter("age");
		age = Integer.parseInt(Age);
		
		if (age >= 20) {
			response.sendRedirect("pass.jsp");
		} else {
			response.sendRedirect("nopass.jsp");
		}
	%>
</body>
</html>