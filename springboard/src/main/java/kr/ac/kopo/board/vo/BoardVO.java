package kr.ac.kopo.board.vo;

public class BoardVO {
	private int no;
	
	@javax.validation.constraints.NotEmpty(message = "제목 쓰세요")
	private String title;
	@javax.validation.constraints.NotEmpty(message = "필수항목입니다")
	private String writer;
	@javax.validation.constraints.NotEmpty(message = "필수항목입니다")
	private String content;
	private String regDate; // "reg_date"
	private int count;
	private int[] numbers;
	
	public BoardVO() {}
	
	public BoardVO(int no, String title, String writer, String content, String regDate, int count, int[] numbers) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
		this.count = count;
		this.numbers = numbers;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int[] getNumbers() {
		return numbers;
	}
	
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
	
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", count=" + count + "]";
	}

}

