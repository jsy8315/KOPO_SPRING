package com.jsp.ex.command;

import java.util.ArrayList;

import com.jsp.ex.dao.BDao;
import com.jsp.ex.dto.BDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BListCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		/*dao에서 리스트 메소드를 호출해서 사용*/
		request.setAttribute("list", dtos);
	}

}
