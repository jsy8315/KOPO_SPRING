package com.openbanking.dto;

import java.sql.Timestamp;

public class BoardDto {

	int bId;
	//글의 id, 시퀀스에 의해 자동으로 매겨짐
	String bWid; //작성자 ID
	String bTitle; //글 제목
	String bContent; //글 내용
	Timestamp bDate; //시간, 자동으로 현재 시간 세팅되게
	int bHit; //조회수
	String bTopic; //주제, 토픽에 따라 나눈다. IT는 1, 스포츠는 2, 경제 3, 정치 4, 의료5
	
	public BoardDto() {
		
	}
	
	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbWid() {
		return bWid;
	}

	public void setbWid(String bWid) {
		this.bWid = bWid;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public String getbTopic() {
		return bTopic;
	}

	public void setbTopic(String bTopic) {
		this.bTopic = bTopic;
	}

	public BoardDto(int bId, String bWid, String bTitle, String bContent, Timestamp bDate, int bHit, String bTopic) {
		this.bId = bId;
		this.bWid = bWid;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
		this.bHit = bHit;
		this.bTopic = bTopic;	
	}
}
