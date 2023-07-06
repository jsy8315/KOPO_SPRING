<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.co.jsplec.ex02.MemberDAO" %>

<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="kr.co.jsplec.ex02.MemberDTO" scope="page "/>
<jsp:setProperty name="dto" property="*" /> 

<%
	String id = (String)session.getAttribute("id");
	dto.setId(id);

	MemberDAO dao = MemberDAO.getInstance();
	int ri = dao.updateMember(dto);
	
	if(ri == 1) {
%>
	<script language="javascript">
		alert("정보 수정 되었습니다.")
		document.location.href="main.jsp";
	</script>
<%
	} else {
%>
	<script language="javascript">
		alert("정보 수정 실패입니다.")
		history.go(-1);
	</script>
<%
	} 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>