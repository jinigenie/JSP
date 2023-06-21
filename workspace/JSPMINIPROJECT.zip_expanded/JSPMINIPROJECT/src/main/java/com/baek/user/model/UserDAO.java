package com.baek.user.model;

public class UserDAO {

	//싱글톤 형태의 클래스로 생성하는 편이 좋다.(싱글톤 - 여러개 호출되어도 한개의 객체만 반환)
	//1. 나 자신의 객체를 스태틱으로 선언
	private static UserDAO instance = new UserDAO();
	//2. 직접 생성하지 못하도록 생성자 제한
	private UserDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//3. getter를 통해서 객체를 반환
	public static UserDAO getInstance() {
		return instance;
	}
	//데이터베이스 연결주소
	//오라클 커넥터
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String uid="JSPMINI";
	private String upw="JSP";

}
