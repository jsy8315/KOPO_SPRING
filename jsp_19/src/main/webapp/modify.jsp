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
<h1>회원정보수정</h1>
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
		아이디 : <%=id%><br />
		비밀번호 : <input type="text" name="pwd" size="10"><br />
		이름 : <input type="text" name="name" size="10" value=<%=name%>><br />
		전화번호 : <input type="text" name="phone" size="10" value=<%=phonenumber%>>
		<%
			if(gender.equals("man")) {
		%>
		성별구분<br>
			남<input type="radio" name="gender" value="man">
			여<input type="radio" name="gender" value="woman"><br>
		<%
			} else { 
		%>
		성별구분<br>
			남<input type="radio" name="gender" value="man">
			여<input type="radio" name="gender" value="woman"><br>
		<%
			}
		%>
		<input type="submit" name="submit" value="정보수정"><br>
	</form>
	
</body>
</html>