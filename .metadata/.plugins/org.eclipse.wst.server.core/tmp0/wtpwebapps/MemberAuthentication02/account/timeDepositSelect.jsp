<%@page import="dataControl.dao.*"%>
<%@page import="dataControl.dto.*"%>
<%@ page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-collapse: collapse;
		width: 100%;
	}

	th, td {
		border: 1px solid black;
		padding: 8px;
		text-align: left;
	}

	th {
		background-color: #f2f2f2;
	}
</style>
</head>
<body>
	<h2>상품 내역 확인</h2>
	<table>
		<tr>
			<th>상품코드</th>
			<th>상품분류</th>
			<th>상품이름</th>
			<th>가입</th>
		</tr>
		<%
			TimeDepositDAO timedepositDAO = new TimeDepositDAO();
			ArrayList<TimeDepositDTO> dtoList = timedepositDAO.timeDepositSelect();

			for (TimeDepositDTO dto : dtoList) {
				String timeDepositCode = dto.getTimeDepositCode();
				String timeDepositType = dto.getTimeDepositType();
				String timeDepositName = dto.getTimeDepositName();
		%>
		<tr>
			<td><%= timeDepositCode %></td>
			<td><%= timeDepositType %></td>
			<td><%= timeDepositName %></td>
			<td>
				<form action="accountInsert.jsp" method="post">
					<input type="hidden" name="timeDepositCode" value="<%= timeDepositCode %>">
					<input type="hidden" name="timeDepositType" value="<%= timeDepositType %>">
					
					<input type="submit" value="가입하기">
				</form>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
