package com.jsplec.ex01;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DispatchTest")
public class DispatchTest extends HttpServlet {
		private static final long serialVersionUID = 1L;

    public DispatchTest() {
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}
		@Override
			protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("UTF-8");
			
				request.setAttribute("name", "suyoung"); //name에 suyoung저장
				request.setAttribute("id", "gwangmyeong");
			
				//hello라고 서블릿맵핑이 되어있는 곳에서도 request, response 객체가 사용
				RequestDispatcher dispatcher = request.getRequestDispatcher("/hello");
				dispatcher.forward(request, response);
	}
	
}
