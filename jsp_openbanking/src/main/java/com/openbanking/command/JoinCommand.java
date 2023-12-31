package com.openbanking.command;

import com.openbanking.dao.MemberDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JoinCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String mId = request.getParameter("id");
		String mName = request.getParameter("name");
		String mPw = request.getParameter("pw");
		String mCp = request.getParameter("cp");
		String mMail = request.getParameter("mail");
		
		MemberDao memberdao = new MemberDao();
		memberdao.join(mId, mName, mPw, mCp, mMail);		
	}

}
