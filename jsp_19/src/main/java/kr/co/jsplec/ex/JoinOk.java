package kr.co.jsplec.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinOk
 */

@WebServlet("/joinOk")
public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private Statement stmt;
    
	private String id, name, pw, gender, phonenumber;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void actionDo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		id = request.getParameter("id");
		pw = request.getParameter("pwd");
		name = request.getParameter("name");
		phonenumber = request.getParameter("phone");
		gender = request.getParameter("gender");
		
		//query문을 사용해 insert
		String query = "INSERT INTO MEMBER VALUES('" + id + "','" + pw + "','" + name + "','" + phonenumber + "','" + gender + "')";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/dink17", "C##SCOTT", "TIGER");
			stmt = connection.createStatement();
			int i = stmt.executeUpdate(query);
			if (i == 1) {
				System.out.println("insert 성공");
				response.sendRedirect("joinResult.jsp");
			} else {
				System.out.println("insert 실패");
				response.sendRedirect("join.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(connection != null) connection.close();
			} catch (Exception e) {}
		}
	}
}
