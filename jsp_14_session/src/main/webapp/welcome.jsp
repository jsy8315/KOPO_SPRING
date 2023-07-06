<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 성공</h1>
	<%
		//단일 세션 정보 얻기
		String sessionId = (String)session.getAttribute("sessionId");
		out.println(sessionId + "님 반갑습니다. <br>");
		String sessionPw = (String)session.getAttribute("sessionPw");
		out.println("당신의 비밀번호는 " +sessionPw +"입니다. <br />");
	%>
<h1>설성된 모든 세션의 키와 값을 얻어와서 출력해보겠음!</h1>
	<%
		//모든 세션 정보 얻기
		String Is_name = "";
		String Is_value = "";
		
		Enumeration enum_all = session.getAttributeNames();
		int i = 0;
		
		while(enum_all.hasMoreElements()) {
			
			i++;
			Is_name = enum_all.nextElement().toString();
			Is_value = session.getAttribute(Is_name).toString();
			
			out.println("<br/>세션 이름["+ i + "]:" + Is_name + "<br/>");
			out.println("<br/>세션 값["+ i + "]:" + Is_value + "<br/>");
		}
	
	%>
	<a href="logout.jsp">로그아웃</a>
</body>
</html>