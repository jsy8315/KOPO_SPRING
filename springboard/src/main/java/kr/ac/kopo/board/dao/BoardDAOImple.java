package kr.ac.kopo.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;

@Repository
public class BoardDAOImple implements BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<BoardVO> getAllPost() {
		return sqlSessionTemplate.selectList("spring.board.dao.BoardDAO.selectAll");
		// TODO Auto-generated method stub      spring.board.dao.BoardDAO
	}
	@Override
	public BoardVO getPostbyNo(int no) {
		// TODO Auto-generated method stub
		BoardVO boardVO = sqlSessionTemplate.selectOne("spring.board.dao.BoardDAO.selectbyNo", no);
		return boardVO;
	}
	@Override
	public void writeNewPost(BoardVO boardVO) {
		sqlSessionTemplate.insert("spring.board.dao.BoardDAO.insert", boardVO);
		
	}
	
	
}
