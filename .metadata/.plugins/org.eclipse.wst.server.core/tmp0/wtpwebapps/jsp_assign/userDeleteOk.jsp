<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="kr.co.jspassign.MemberDAO" %>
<%@ page import="kr.co.jspassign.MemberDTO" %>
<%@ page import="kr.co.jspassign.MemberDAO" %>

<% request.setCharacterEncoding("UTF-8"); %>

<%
	String id = (String) session.getAttribute("id");
    MemberDAO dao = MemberDAO.getInstance();
    int ri = dao.deleteRequestMember(id);
    if (ri == 1) {
%>
    <script language="javascript">
        alert("관리자에게 탈퇴 요청을 보냈습니다. 이제 해당 아이디로 로그인이 불가합니다. ");
        window.location.href="logout.jsp";
    </script>
<%
    } else {
%>
    <script language="javascript">
        alert("탈퇴 요청 전송 실패");
        history.go(-1);
    </script>
<%
    } 
%>
