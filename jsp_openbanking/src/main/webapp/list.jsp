<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter"%>
<% if(session.getAttribute("ValidMem") != null) {%>
	<jsp:forward page="adminMain.jsp"></jsp:forward>	
<% }%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP 게시판</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #e6e6e6;
        }
    </style>
</head>
<body>
    <h1>데브리타임</h1>
    	<form action="login.do" method="post" align="right">
			아이디&nbsp;<input type="text" name="id" value="<% if(session.getAttribute("id") != null) out.println(session.getAttribute("id")); %>">
			비밀번호&nbsp;<input type="password" name="pw">
			<input type="submit" value="로그인">
		  	<%
    			String clientId = "OeudOcIy6D5r8PXWPnVA";//애플리케이션 클라이언트 아이디값";
    			String redirectURI = URLEncoder.encode("http://192.168.123.24:8080/jsp_assign/naverLoginCallback.jsp", "UTF-8");
    			SecureRandom random = new SecureRandom();
    			String state = new BigInteger(130, random).toString();
    			String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    			apiURL += "&client_id=" + clientId;
    			apiURL += "&redirect_uri=" + redirectURI;
    			apiURL += "&state=" + state;
    			session.setAttribute("state", state);
 		  	%>
			<a href="<%=apiURL%>"><img height="30" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
			<input type="button" value="회원가입" onclick="javascript:window.location='join.jsp'"><br />
		</form><br />
    <table>
        <thead>
            <tr>
                <th>글번호</th>
                <th>작성자ID</th>
                <th>제목</th>
                <th>작성일</th>
                <th>조회수</th>
                <th>주제</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="boarddto">
                <tr>
                    <td>${boarddto.bId}</td>
                    <td>${boarddto.bWid}</td>
                    <td>
                    	<c:forEach begin="1" end="${boarddto.bIndent }">-</c:forEach>
                    	<a href="content_view.do?bId=${boarddto.bId}">${boarddto.bTitle}</a>
                    	<!-- 글의 제목을 클릭하면 글 확인/수정/삭제/답글이 가능하도록 가능 -->
                    	<!-- id에 해당하는 글 꺼내도록 -->
					</td>
                    <td>${boarddto.bDate}</td>
                    <td>${boarddto.bHit}</td>
                    <td>${boarddto.bTopic}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="write_view.do" class="btn btn-primary pull-right">글작성</a>
</body>
</html>
