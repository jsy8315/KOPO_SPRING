<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.jspassign.MemberDAO" %>
<%@ page import="kr.co.jspassign.MemberDTO" %>
    
<%
	String id = (String) session.getAttribute("id");
	request.setCharacterEncoding("UTF-8");
	MemberDAO dao = MemberDAO.getInstance();
	MemberDTO dto = dao.getMember(id);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script langauge="JavaScript" src="members.js"></script>
</head>
<body>
	<form action="userModifyOk.jsp" method="post" name="reg_frm">
		아이디&nbsp;<%= dto.getId()%><br /> 
		이름&nbsp;<input type="text" name="name" size="10"><br>
		비밀번호&nbsp;<input type="password" name="pw" size="20"><br />
		비밀번호 확인&nbsp;<input type="password" name="pw_check" size="20"><br />
		전화번호&nbsp;<input type="text" name="cp" size="20"><br>
		이메일&nbsp;<input type="text" name="mail" size="50"><br>
		회원상태&nbsp;<%= dto.getStatus() %><br />
		회원권한&nbsp;<%= dto.getAuthority() %><br />
		<input type="button" value="수정" onclick ="updateUserInfoConfirm()">
		<input type="reset" value="취소" onclick="javascript:window.location='userMain.jsp'">
		<input type="button" value="탈퇴요청" onclick="javascript:window.location='userDeleteOk.jsp'">
	</form>
</body>
</html>