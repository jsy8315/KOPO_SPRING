package kr.co.jsplec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld2
 */
@WebServlet("/HWorld2")
public class HelloWorld2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("HelloWorld2 실행중");
		System.out.println("get방식으로 진행중");
		
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter pw = response.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>미남 홀란드 미남 음~밥해</h1>");
		pw.println("<h2>get방식으로 진행중</h2>");
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("HelloWorld2 실행중");
		System.out.println("post방식으로 진행중");
		
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter pw = response.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>미남 홀란드 미남 음~밥해</h1>");
		pw.println("<h2>post방식으로 진행중</h2>");
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
		
	}

}
