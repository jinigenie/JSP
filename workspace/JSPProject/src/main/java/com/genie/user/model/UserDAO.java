package com.genie.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class UserDAO {

	//싱글톤 형태의 클래스로 생성하는 편이 좋음
	//1. 나 자신의 객체를 static으로 선언
	private static UserDAO instance = new UserDAO();

	//2. 직접 생성하지 못하도록 생성자 제한
	private UserDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		}
	}

	//3. getter를 통해서 객체 반환
	public static UserDAO getInstance() {
		return instance;
	}

	// DB 연결 주소 + 오라클 커넥터
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "JSP";
	private String upw = "JSP";



	// 아이디 중복체크 
	public int idCheck(String id) {

		int res = 1;

		String sql = "select * from users where id = ?";


		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		try {

			//			Class.forName("oracle.jdbc.driver.OracleDriver");

			//1. Connector
			conn = DriverManager.getConnection(url, uid, upw);

			//2. pstmt - sql을 실행하기 위한 클래스
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			//3. ResultSet
			rs = pstmt.executeQuery();

			if(rs.next()) { // sql문에서 중복이면 true 반환

				res = 1;

			} else { // 중복 아님

				res = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {

			}

		}

		return res;
	}

	// 회원가입
	public void join(UserVO vo) {

		String sql = "insert into users(id, pw, name, email, gender) values(?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getGender());

			pstmt.executeUpdate();
			
			

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {

			}

		}

	}

	// 로그인
	public UserVO login(String id, String pw) {

		// 로그인 성공이면 객체가 반환, 로그인 샐패면 null값이 반환
		UserVO vo = null;

		int res = 0;

		String sql = "select * from users where id = ? and pw = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if(rs.next()) {

				String id2 = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				Timestamp regdate = rs.getTimestamp("regdate");

				vo = new UserVO(id2, null, name, email, gender, regdate);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {

			}
		}

		return vo;

	}

	// 회원정보 조회
	public UserVO getInfo(String id) {

		UserVO vo = null;

		String sql = "select * from users where id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery(); 

			if(rs.next()) { // id는 pk라서 1행

				String id2 = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String gender = rs.getString("gender");

				vo = new UserVO(id2, null, name, email, gender, null);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}

		return vo;
	}

	// 회원정보 수정
	public int updateInfo(UserVO vo) {

		int r = 0;

		String sql = "update users set pw = ?, name = ? , email = ?, gender = ? where id = ?";


		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getId());

			r = pstmt.executeUpdate(); //성공 1, 실패 0 반환


			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			return r;
		}


	}
