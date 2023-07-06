package kr.co.jspassign;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.http.HttpServletRequest;

public class MemberDAO {
	public static final int MEMBER_NONEXISTENT = 0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PAUSE = 2;
	public static final int MEMBER_LOGIN_DENIED = 3;
	public static final int MEMBER_LOGIN_IS_NOT = -1;
	public static final int MEMBER_LOGIN_ADMIN = 1;
	public static final int MEMBER_LOGIN_USER = 0;
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public int insertMember(MemberDTO dto) {
		int ri = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "insert into polyuser values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1,  dto.getId());
			pstmt.setString(2,  dto.getName());
			pstmt.setString(3,  dto.getPw());
			pstmt.setString(4,  dto.getCp());
			pstmt.setString(5,  dto.getMail());
			pstmt.setString(6,  "승인전");
			pstmt.setString(7,  "일반사용자");
			pstmt.executeUpdate();
			ri = MemberDAO.MEMBER_JOIN_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}
	
	public int confirmId(String id) {
		int ri = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select id from polyuser where id = ?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			if(set.next()) {
				ri = MemberDAO.MEMBER_EXISTENT;
			} else {
				ri = MemberDAO.MEMBER_NONEXISTENT;
			}		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}
	
	public int userCheck(String id, String pw) {
		int ri = 0;
		String dbPw;
		String dbStatus;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select pw, status from polyuser where id = ?";//DB에서 ID에 해당하는 PW 가져옴
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query); 
			pstmt.setString(1, id); //쿼리문에서 
			set = pstmt.executeQuery(); //DB에서 가져온 찐 PW
			if(set.next()) {
				dbPw = set.getString("pw"); //DB에서 가져온 찐 PW
				dbStatus = set.getString("status");
				if(dbPw.equals(pw)) {
					if(dbStatus.equals("정상")) { 
						ri = MemberDAO.MEMBER_LOGIN_SUCCESS; //1 로그인 성공
					} else if(dbStatus.equals("일시정지")) {
						ri = MemberDAO.MEMBER_LOGIN_PAUSE; //2, 일시정지 상태
					} else {
						ri = MemberDAO.MEMBER_LOGIN_DENIED; //3, 승인 전
					}
				} else {
					ri = MemberDAO.MEMBER_LOGIN_PW_NO_GOOD; //0 비밀번호틀림
				}	
			} else {
				ri = MemberDAO.MEMBER_LOGIN_IS_NOT; //-1 아이디가 존재하지않음
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}
	public int authorityCheck(String id) {
		int ri = 0;
		String dbAu;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select authority from polyuser where id = ?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			if(set.next()) {
				dbAu = set.getString("authority");
				if(dbAu.equals("관리자")) {
					ri = MemberDAO.MEMBER_LOGIN_ADMIN;	//1 관리자
				} else {
					ri = MemberDAO.MEMBER_LOGIN_USER;	//0 일반사용자
				}	
			} else {
				ri = MemberDAO.MEMBER_LOGIN_IS_NOT;	//-1 없는 사용자
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}
	
	public List<MemberDTO> selectAll() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		List<MemberDTO> res = new ArrayList<MemberDTO>();
		String query = "select * from POLYUSER";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);

			set = pstmt.executeQuery();
			
			while(set.next()) {
				MemberDTO tmp = new MemberDTO();
				tmp.setId(set.getString(1));
				tmp.setName(set.getString(2));
				tmp.setPw(set.getString(3));
				tmp.setCp(set.getString(4));
				tmp.setMail(set.getString(5));
				tmp.setStatus(set.getString(6));
				tmp.setAuthority(set.getString(7));
				
				res.add(tmp);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return res;
	}	
	
	public MemberDTO getMember(String id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select * from polyuser where id = ?";
		MemberDTO dto = null;
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				dto = new MemberDTO();
				dto.setId(set.getString("id"));
				dto.setName(set.getString("name"));
				dto.setPw(set.getString("pw"));
				dto.setCp(set.getString("cp"));
				dto.setMail(set.getString("mail"));
				dto.setStatus(set.getString("status"));
				dto.setAuthority(set.getString("authority"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}	
	public int updateMember(MemberDTO dto) {
	    int ri = 0;
	    
	    String id = dto.getId();
	    String name = dto.getName();
	    String mail = dto.getMail();
	    String status = dto.getStatus();
	    String authority = dto.getAuthority();
	    
	    Connection connection = null;
	    PreparedStatement pstmt = null;
	    String query = "UPDATE polyuser SET name=?, mail=?, status=?, authority=? WHERE id=?";
	    
	    try {
	        connection = getConnection();
	        pstmt = connection.prepareStatement(query);
	        pstmt.setString(1, name);
	        pstmt.setString(2, mail);
	        pstmt.setString(3, status);
	        pstmt.setString(4, authority);
	        pstmt.setString(5, id);
	        ri = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }
	    return ri;
	}
	
	public int updateMemberUser(MemberDTO dto) {
	    int ri = 0;
	    
	    String id = dto.getId();
	    String name = dto.getName();
	    String pw = dto.getPw();
	    String cp = dto.getCp();
	    String mail = dto.getMail();
	    
	    Connection connection = null;
	    PreparedStatement pstmt = null;
	    String query = "UPDATE polyuser SET name=?, pw=?, cp=?, mail=? WHERE id=?";
	    
	    try {
	        connection = getConnection();
	        pstmt = connection.prepareStatement(query);
	        pstmt.setString(1, name);
	        pstmt.setString(2, pw);
	        pstmt.setString(3, cp);
	        pstmt.setString(4, mail);
	        pstmt.setString(5, id);
	        ri = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }
	    return ri;
	}

	public int deleteRequestMember(String id) {
	    int ri = 0;
	    
	    
	    Connection connection = null;
	    PreparedStatement pstmt = null;
	    String query = "UPDATE polyuser SET status=? WHERE id=?";
	    
	    try {
	        connection = getConnection();
	        pstmt = connection.prepareStatement(query);
	        pstmt.setString(1, "탈퇴요청");
	        pstmt.setString(2, id);
	        ri = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }
	    return ri;
	}
	
	
	public int deleteMember(MemberDTO dto) {
	    int ri = 0;
	    
	    String id = dto.getId();
	    
	    Connection connection = null;
	    PreparedStatement pstmt = null;
	    String query = "DELETE FROM POLYUSER WHERE id=?";
	    
	    try {
	        connection = getConnection();
	        pstmt = connection.prepareStatement(query);
	        pstmt.setString(1, id);
	        ri = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }
	    return ri;
	}


	
	private Connection getConnection() {
		Context context = null;
		DataSource dataSource = null;
		Connection connection = null;
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			connection = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}

