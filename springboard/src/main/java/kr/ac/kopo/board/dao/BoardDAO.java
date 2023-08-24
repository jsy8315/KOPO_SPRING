package kr.ac.kopo.board.dao;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardDAO {
	List<BoardVO> getAllPost();
	BoardVO getPostbyNo(int no);
	void writeNewPost(BoardVO boardVO);
}
