<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- <% response.setStatus(200);%>
	<%= exception.getMessage() %> 
-->
발생한 예외 종류 : <%= exception.getClass().getName() %>
</body>
</html>