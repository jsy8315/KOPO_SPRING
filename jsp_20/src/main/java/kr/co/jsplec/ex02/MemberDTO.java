package kr.co.jsplec.ex02;

import java.sql.Timestamp;

import javax.xml.crypto.Data;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String phonenumber;
	private String gender;
	private Timestamp rDate;
	
	public MemberDTO(String id, String pw, String name, String phonenumber, String gender) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phonenumber = phonenumber;
		this.gender = gender;
	}
	
	public MemberDTO() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getrDate() {
		return rDate;
	}

	public void setrDate(Timestamp rDate) {
		this.rDate = rDate;
	}

}
