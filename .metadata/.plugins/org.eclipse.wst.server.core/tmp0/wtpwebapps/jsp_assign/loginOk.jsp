<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.jspassign.MemberDAO" %>
<%@ page import="kr.co.jspassign.MemberDTO" %>

<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDAO dao = MemberDAO.getInstance();
	int checkNum = dao.userCheck(id, pw); //로그인 확인
	int authcheckNum = dao.authorityCheck(id); //관리자, 사용자 확인
	
	if(checkNum == -1) {
%>
	<script language="javascript">
		alert("아이디가 존재하지 않습니다.")
		history.go(-1);
	</script>
<%
	} else if(checkNum == 0) {
%>
	<script language="javascript">
		alert("비밀번호가 틀립니다")
		history.go(-1);
	</script>
<%
	} else if(checkNum == 2) {
%>
	<script language="javascript">
		alert("회원님의 계정이 일시정지 상태입니다. 관리자에게 문의하세요.")
		history.go(-1);
	</script>
<%
	} else if(checkNum == 3) {
%>
	<script language="javascript">
		alert("회원님의 계정이 아직 승인되지 않았습니다. 승인은 관리자맘입니다. 메롱")
		history.go(-1);
	</script>
<%
	} else if(checkNum == 1) {
		MemberDTO dto = dao.getMember(id);
		
		if(dto == null) {
%>
	<script language="javascript">
		alert("존재하지 않는 회원입니다.")
		history.go(-1);
	</script>
<%
		} else {
			
			if(authcheckNum == 1) {
%>
			<script language="javascript">
				alert("관리자입니다.")
			</script>
<%				
			String name = dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMem", "yes");
			response.sendRedirect("adminMain.jsp");
			} else if(authcheckNum == 0){
%>
				<script language="javascript">
					alert("일반사용자입니다.")
				</script>
<%
			String name = dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMem", "yes");
			response.sendRedirect("userMain.jsp");
			} else {
%>
				<script language="javascript">
					alert("아이디가 존재하지 않습니다.")
					history.go(-1);
				</script>
<%
				}
			}
		}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginOk.jsp</title>
</head>
<body>

</body>
</html>