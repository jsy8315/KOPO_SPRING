package com.jsp.ex.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface BCommand {
	void execute(HttpServletRequest request, HttpServletResponse response);
	/*해당 인터페이스를 구현하는 클래스에서, execute() 메서드를 오버라이딩하여 실제 동작을 구현하도록함*/
	/*이 자체로 무엇을 반환하지는 않음(void)*/
}
