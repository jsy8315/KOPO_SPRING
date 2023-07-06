<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="kr.co.jspassign.MemberDAO" %>
<%@ page import="kr.co.jspassign.MemberDTO" %>
<%@ page import="kr.co.jspassign.MemberDAO" %>

<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="kr.co.jspassign.MemberDTO" scope="page"/>
<jsp:setProperty name="dto" property="*" /> 

<%
	String sessionId = (String) session.getAttribute("sessionId");
    MemberDAO dao = MemberDAO.getInstance();
    int ri = dao.deleteMember(dto);
    if (ri == 1) {
%>
    <script language="javascript">
        alert("삭제 되었습니다.");
        window.location.href="adminModify.jsp";
    </script>
<%
    } else {
%>
    <script language="javascript">
        alert("삭제 실패입니다.");
        history.go(-1);
    </script>
<%
    } 
%>
