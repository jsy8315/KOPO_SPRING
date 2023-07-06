<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.jsplec.ex02.MemberDAO" %>
<%@ page import="kr.co.jsplec.ex02.MemberDTO" %>

<%
	String id = (String)session.getAttribute("id");
	MemberDAO dao = MemberDAO.getInstance();
	MemberDAO dto = dao.getMember(id);
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="modifyOk.jsp" method="post" name="reg_frm">
		아이디&nbsp;<%= dto.getId()%><br />
		비밀번호&nbsp;<input type="password" name="pw" size="20"><br />
		비밀번호 확인&nbsp;<input type="password" name="pw_check" size="20"><br />
		이름&nbsp;<%= dto.getName()%><br>
		성별&nbsp;;<input type="radio" name="gender" size="50" value="<%= dto.getGender() %>"><br>
		전화번호&nbsp;<input type="text" name="phonenumber" size="50" value="<%= dto.getPhonenumber() %>"><br>
		<input type="button" value="수정" onclick="updateInfoConfirm()">
			<input type="reset" value="취소" onclick="javascript:window.location='login.jsp'">
	</form>
</body>
</html>