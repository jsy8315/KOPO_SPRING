<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>ȸ����������</h1>
	<%!
		Connection connection;
		Statement stmt;
		ResultSet resultSet;
		
		String id, name, pw, gender, phonenumber;
	%>
	
	<%
		id = (String)session.getAttribute("id");
	
		String query = "SELECT * FROM MEMBER WHERE ID = '" + id + "'";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.217.202:1521/KOPODA", "da2317", "da17");
		stmt = connection.createStatement();
		resultSet = stmt.executeQuery(query);
		
		while (resultSet.next()) {
			id = resultSet.getString("id");
			pw = resultSet.getString("pw");
			name = resultSet.getString("name");
			phonenumber = resultSet.getString("phonenumber");
			gender = resultSet.getString("gender");
		}
	%>
	
	<form action="ModifyOk" method="post">
		���̵� : <%=id%><br />
		��й�ȣ : <input type="text" name="pwd" size="10"><br />
		�̸� : <input type="text" name="name" size="10" value=<%=name%>><br />
		��ȭ��ȣ : <input type="text" name="phone" size="10" value=<%=phonenumber%>>
		<%
			if(gender.equals("man")) {
		%>
		��������<br>
			��<input type="radio" name="gender" value="man">
			��<input type="radio" name="gender" value="woman"><br>
		<%
			} else { 
		%>
		��������<br>
			��<input type="radio" name="gender" value="man">
			��<input type="radio" name="gender" value="woman"><br>
		<%
			}
		%>
		<input type="submit" name="submit" value="��������"><br>
	</form>
	
</body>
</html>