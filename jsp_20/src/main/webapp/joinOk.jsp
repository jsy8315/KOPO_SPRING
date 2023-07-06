<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.co.jsplec.ex02.MemberDAO" %>
<%@ page import="kr.co.jsplec.ex02.MemberDTO" %>
<%@ page import="java.sql.Timestamp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="kr.co.jsplec.ex02.MemberDTO"/>
<jsp:setProperty name="dto" property="*" />

<%
	dto.setrDate(new Timestamp(System.currentTimeMillis()));
	MemberDAO dao = MemberDAO.getInstance();
	if(dao.confirmId(dto.getId()) == MemberDAO.MEMBER_EXISTENT) {
%>
	<script language="javascript">
		alert("���̵� �̹� �����մϴ�.")
		history.back();
	</script>
<%
	} else {
		int ri = dao.insertMember(dto);
		if(ri == MemberDAO.MEMBER_JOIN_SUCCESS) {
			session.setAttribute("id", dto.getId());
%>
		<script language="javascript">
			alert("ȸ�������� �����մϴ�.");
			document.location.href="login.jsp";
		</script>
<%
		} else {
%>
		<script language="javascript">
			alert("ȸ������ ����");
			document.location.href="login.jsp";
		</script>	
<%
		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>joinOk</title>
</head>
<body>

</body>
</html>