package com.baek.user.model;

public class UserVO {

	private String id;
	private String pw;
	private String ph;
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}

	public UserVO(String id, String pw, String ph) {
		super();
		this.id = id;
		this.pw = pw;
		this.ph = ph;
	}

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

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}
	
	
}
