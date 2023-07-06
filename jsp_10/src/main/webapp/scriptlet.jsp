<%@page import="java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>  
   <%!
   		int i = 10;
   		String str = "ABCD";
   		
   		private int sum(int x, int y) {
   			return x + y;
   		}
   %>
   
   <%= i %><br />
   <%= str %><br />
   <%= sum(1, 10) %><br />
   
   <%
   int[] iArr = {10, 20, 30};
   out.println(Arrays.toString(iArr));
   %>
</body>
</html>