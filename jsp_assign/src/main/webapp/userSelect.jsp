<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.jspassign.MemberDAO" %>
<%@ page import="kr.co.jspassign.MemberDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>adminModify.jsp</title>
<%
	String id = (String) session.getAttribute("id");
	request.setCharacterEncoding("UTF-8");
	MemberDAO dao = MemberDAO.getInstance();
	MemberDTO dto = dao.getMember(id);
%>
</head>
<body>
<h1>회원관리 페이지</h1>
<form action="userMain.jsp" method="post">
	<input type="reset" value="뒤로가기" onclick="javascript:window.location='userMain.jsp'">
</form>
<table border="1">
	<col width="50"><col width="100"><col width="100"><col width="100">
	<col width="300"><col width="150"><col width="200"><col width="50"><col width="50">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>PW</th>
		<th>CP</th>
		<th>MAIL</th>
		<th>STATUS</th>
		<th>AUTHORITY</th>
	</tr>

	<tr>
		<td><%=dto.getId() %></td>
		<td><%=dto.getName() %></td>
		<td><%=dto.getPw() %></td>
		<td><%=dto.getCp() %></td>
		<td><%=dto.getMail() %></td>
		<td><%=dto.getStatus() %></td>
		<td><%=dto.getAuthority() %></td>
	</tr>	
</table>
</body>
</html>