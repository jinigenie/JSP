package com.demo.bean;

public class Member {

	/*
	 * 자바빈은 form과 DB의 통신 과정에서 변수 처리를 쉽게하기 위해 사용
	 * 자바빈 : 서버에 미리 생성되어있는 객체 
	 */
	
	private String id;
	private String pw;
	private String name;
	
	// 생성자는 기본생성자 + 전체생성자 만들기
	public Member() {
	}

	public Member(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	// getter, setter
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
	
	
	
	
	
}
