<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String inputId = request.getParameter("inputId");
		String inputPasswd = request.getParameter("inputPasswd");
		String inputName = request.getParameter("inputName");
		String inputNumber = request.getParameter("inputNumber");

	%>
	<%
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.217.202:1521:xe";
		String uid = "da2317";
		String upw = "da17";;
		String query = "select * from member";
	%>
	<%
		Connection con;
		PreparedStatement pstmt;
		
		try {
		Class.forName(driver);
		con = DriverManager.getConnection(url, uid, upw);
		String sql = "SELECT * FROM MEMBER";
		pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	%>	
</body>
</html>