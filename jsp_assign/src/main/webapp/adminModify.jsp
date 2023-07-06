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
	String sessionId = (String) session.getAttribute("sessionId");
	request.setCharacterEncoding("UTF-8");
	MemberDAO dao = MemberDAO.getInstance();
	List<MemberDTO> res = new ArrayList<MemberDTO>();
	res = dao.selectAll();
%>
</head>
<body>
<h1>회원관리 페이지</h1>
<form action="logout.jsp" method="post">
	<input type="reset" value="로그아웃" onclick="javascript:window.location='logout.jsp'">
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
		<th>회원정보수정</th>
		<th>회원정보삭제</th>
	</tr>
<%	
	for(int i = 0; i<res.size(); i++){
		MemberDTO md = res.get(i);
		String marked = "010-XXXX-XXXX";
%>
	<tr>
		<td><%=md.getId() %></td>
		<td><%=md.getName() %></td>
		<td><%=md.getPw() %></td>
		<td><%= marked %></td>
		<td><%=md.getMail() %></td>
		<td><%=md.getStatus() %></td>
		<td><%=md.getAuthority() %></td>
		<td><input type="button" value="정보수정" onclick="javascript:window.location='adminModifyOk.jsp?id=<%=md.getId()%>'"></td>
		<td><input type="button" value="삭제" onclick="javascript:window.location='adminDeleteOk.jsp?id=<%=md.getId()%>'"></td>
	</tr>	
<%
	}
%>
</table>
</body>
</html>