package com.jsplec.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
       
    public HelloServlet() {
    }
    	@Override
    	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		request.setCharacterEncoding("UTF-8");
    		response.setContentType("text/html;charset=UTF-8");
    		
    		PrintWriter out = response.getWriter();
    		out.println("<HTML><HEAD></HEAD><BODY>");
    		out.println("<H1>HELLO</H1>");
    		out.println("<H1>HELLO" + request.getAttribute("name") + "</H1>");
    		out.println("<H1>HELLO" + request.getAttribute("id") + "</H1>");
    		
    		out.println("</BODY></HTML>");
    		out.close();
    	}

    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	}

    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	}

}