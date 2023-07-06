<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.jspassign.MemberDAO" %>
<%@ page import="kr.co.jspassign.MemberDTO" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="kr.co.jspassign.MemberDTO"/>
<jsp:setProperty name="dto" property="*" />

<%
	MemberDAO dao = MemberDAO.getInstance();
	if(dao.confirmId(dto.getId()) == MemberDAO.MEMBER_EXISTENT) {
%>
	<script language="javascript">
		alert("아이디가 이미 존재합니다.")
		history.back();
	</script>
<%
	} else {
		int ri = dao.insertMember(dto);
		if(ri == MemberDAO.MEMBER_JOIN_SUCCESS) {
			session.setAttribute("id", dto.getId());
%>
		<script language="javascript">
			alert("회원가입을 축하합니다.");
			document.location.href="login.jsp";
		</script>
<%
		} else {
%>
		<script language="javascript">
			alert("회원가입 실패");
			document.location.href="login.jsp";
		</script>	
<%
		}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>joinOk.jsp</title>
</head>
<body>

</body>
</html>