<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.jspassign.MemberDAO" %>
<%@ page import="kr.co.jspassign.MemberDTO" %>

<%
	String sessionId = (String) session.getAttribute("sessionId");
	String id = request.getParameter("id");
	MemberDAO dao = MemberDAO.getInstance();
	MemberDTO dto = dao.getMember(id);
	String marked = "010-XXXX-XXXX";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보수정 입력폼</title>
<script language="JavaScript" src="members.js" ></script>
</head>
<body>
	<form action="adminModifyOk02.jsp" method="post" name="reg_frm">
		아이디&nbsp;<%= dto.getId()%><br /> 
		<input type="hidden" name="id" value="<%= dto.getId() %>">
		이름&nbsp;<input type="text" name="name" size="10"><br>
		비밀번호&nbsp;<%= dto.getPw()%><br />
		전화번호&nbsp;<%= marked %><br />
		이메일&nbsp;<input type="text" name="mail" size="50"><br>
		회원상태 : &nbsp;
			정상<input type="radio" name="status" value="정상">
			승인전<input type="radio" name="status" value="승인전">
			일시정지<input type="radio" name="status" value="일시정지"><br>
		회원권한 : &nbsp;
			관리자<input type="radio" name="authority" value="관리자">
			일반사용자<input type="radio" name="authority" value="일반사용자"><br>
		<input type="button" value="수정" onclick = "updateInfoConfirm('<%= dto.getId() %>')">
			<input type="reset" value="취소" onclick="javascript:window.location='adminModify.jsp'">
	</form>
</body>
</html>