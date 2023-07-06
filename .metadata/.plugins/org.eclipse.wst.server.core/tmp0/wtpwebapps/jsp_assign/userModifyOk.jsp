<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="kr.co.jspassign.MemberDAO" %>
<%@ page import="kr.co.jspassign.MemberDTO" %>

<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="kr.co.jspassign.MemberDTO" scope="page"/>
<jsp:setProperty name="dto" property="*" /> 

<%
	String id = (String)session.getAttribute("id");
	dto.setId(id);
	
    MemberDAO dao = MemberDAO.getInstance();
    int ri = dao.updateMemberUser(dto);
    
    if (ri == 1) {
%>
    <script language="javascript">
        alert("정보 수정 되었습니다.");
        document.location.href="userMain.jsp";
    </script>
<%
    } else {
%>
    <script language="javascript">
        alert("정보 수정 실패");
        history.go(-1);
    </script>
<%
    } 
%>