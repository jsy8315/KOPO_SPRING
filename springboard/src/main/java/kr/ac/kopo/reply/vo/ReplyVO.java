package kr.ac.kopo.reply.vo;

public class ReplyVO {
	private int no;
	private int boardNo;
	private String writer;
	private String coinent;
	private String regDate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCoinent() {
		return coinent;
	}
	public void setCoinent(String coinent) {
		this.coinent = coinent;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
}
