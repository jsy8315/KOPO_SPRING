package kr.ac.kopo.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.member.vo.LoginVO;

@Repository
public class MemberDAO {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	public MemberVO login(LoginVO loginVO) {
		MemberVO memberVO = 
				sqlSessionTemplate.selectOne(
						"spring.member.dao.MemberDAO.login", loginVO);
		return memberVO;
	}

}
