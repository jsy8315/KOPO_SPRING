package com.openbanking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	DataSource dataSource;
	
	public MemberDao() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void join(String mId, String mName, String mPw, String mCp, String mMail) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into polyuser (Id, Name, Pw, Cp, Mail, status, authority) values (?, ?, ?, ?, ?, '승인전', '일반사용자')";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, mId);
			preparedStatement.setString(2, mName);
			preparedStatement.setString(3, mPw);
			preparedStatement.setString(4, mCp);
			preparedStatement.setString(5, mMail);
			int rn = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public int login(String mId, String mPw) {
		int ri = 0;
		
		String dbPw;
		String dbStatus;
		String dbAuthority;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select pw, status, authority from polyuser where id = ?";//DB에서 ID에 해당하는 PW 가져옴
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, mId);
			
			set = preparedStatement.executeQuery(); //DB에서 가져온 찐 PW
			if(set.next()) {
				dbPw = set.getString("pw"); //DB에서 가져온 찐 PW
				dbStatus = set.getString("status"); //DB에서 가져온 status
				dbAuthority = set.getString("authority"); //DB에서 가져온 authority
				if(dbPw.equals(mPw)) {
					if(dbStatus.equals("정상")) { 
						 //MemberDAO.MEMBER_LOGIN_SUCCESS; 
						if(dbAuthority.equals("관리자")) {
							ri = 1;/*로그인 성공 후 관리자인 경우, 1 로그인 성공 */
						} else {
							ri = 2; /*로그인 성공 후 일반사용자인 경우*/
						}
					} else if(dbStatus.equals("일시정지")) {
						ri = 3; //MemberDAO.MEMBER_LOGIN_PAUSE; //2, 일시정지 상태
					} else { /*승인 전*/
						ri = 4; //MemberDAO.MEMBER_LOGIN_DENIED; //3, 승인 전
					}
				} else {
					ri = 0; //MemberDAO.MEMBER_LOGIN_PW_NO_GOOD; //0 비밀번호틀림
				}	
			} else {
				ri = -1; //MemberDAO.MEMBER_LOGIN_IS_NOT; //-1 아이디가 존재하지않음
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}
	public int loginCheck(String mId, String mPw) {
		int ri = 0;
		
		String dbPw;
		String dbStatus;
		String dbAuthority;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select pw, status, authority from polyuser where id = ?";//DB에서 ID에 해당하는 PW 가져옴
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, mId);
			
			set = preparedStatement.executeQuery(); //DB에서 가져온 찐 PW
			if(set.next()) {
				dbPw = set.getString("pw"); //DB에서 가져온 찐 PW
				dbStatus = set.getString("status"); //DB에서 가져온 status
				dbAuthority = set.getString("authority"); //DB에서 가져온 authority
				if(dbPw.equals(mPw)) {
					if(dbStatus.equals("정상")) { 
						 //MemberDAO.MEMBER_LOGIN_SUCCESS; 
						if(dbAuthority.equals("관리자")) {
							ri = 1;/*로그인 성공 후 관리자인 경우, 1 로그인 성공 */
						} else {
							ri = 2; /*로그인 성공 후 일반사용자인 경우*/
						}
					} else if(dbStatus.equals("일시정지")) {
						ri = 3; //MemberDAO.MEMBER_LOGIN_PAUSE; //2, 일시정지 상태
					} else { /*승인 전*/
						ri = 4; //MemberDAO.MEMBER_LOGIN_DENIED; //3, 승인 전
					}
				} else {
					ri = 0; //MemberDAO.MEMBER_LOGIN_PW_NO_GOOD; //0 비밀번호틀림
				}	
			} else {
				ri = -1; //MemberDAO.MEMBER_LOGIN_IS_NOT; //-1 아이디가 존재하지않음
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}
}
