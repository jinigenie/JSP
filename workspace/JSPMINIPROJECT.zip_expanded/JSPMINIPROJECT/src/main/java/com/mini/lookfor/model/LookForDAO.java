package com.mini.lookfor.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class LookForDAO {

	//싱글톤 형태의 클래스로 생성하는 편이 좋다.(싱글톤 - 여러개 호출되어도 한개의 객체만 반환)

	//1. 나 자신의 객체를 스태틱으로 선언
	private static LookForDAO instance = new LookForDAO();

	//2. 직접 생성하지 못하도록 생성자 제한
	private LookForDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	//3. getter를 통해서 객체를 반환
	public static LookForDAO getInstance() {
		return instance;
	}


	//데이터베이스 연결주소
	//오라클 커넥터
	private String url="jdbc:oracle:thin:@172.30.1.41:1521:xe";
	private String uid="JSPMini";
	private String upw="JSP";


	// LookFor 게시글 작성
	public void writeLf (String type, String date, String area,String title,String content, String id) {

		String sql = "insert into lookfor values(lookfor_SEQ.NEXTVAL, ?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn=DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			pstmt.setString(2, date);
			pstmt.setString(3, area);
			pstmt.setString(4, title);
			pstmt.setString(5, content);
			pstmt.setString(6, id);

			int a =pstmt.executeUpdate();
			System.out.println(a);

		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}

		}

	}


	// 목록 조회
	public List<LookForVO>  getList() {
		List<LookForVO>list= new ArrayList<>();

		String sql = "select * from lookfor ORDER by KEY_NUM desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn= DriverManager.getConnection(url,uid,upw);
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			/*
			 * 조회된 데이터를 순서대로 vo에 담고 리스트에 추가하는 프로그램 코드
			 */
			while(rs.next()) {

				int num=rs.getInt("key_num");
				String type=rs.getString("ani_type");
				String time=rs.getString("lost_time");
				String area=rs.getString("lost_area");
				String title=rs.getString("title");
				String content=rs.getString("content");
				String id=rs.getString("id");

				list.add(new LookForVO(num, type, time, area ,title, content, id));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}


	// 게시글 상세 조회
	public LookForVO getContent(String num) {

		LookForVO vo = null;
		String sql = "select * from lookfor where key_num = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();

			if(rs.next()) {

				int bno2 = rs.getInt("key_num");
				String type=rs.getString("ani_type");
				String time=rs.getString("lost_time");
				String area=rs.getString("lost_area");
				String title=rs.getString("title");
				String content=rs.getString("content");
				String id=rs.getString("id");

				vo = new LookForVO(bno2, type, time, area, title, content, id);

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


	//글 수정 기능
	public void update(String num, String title, String content) {

		String sql = "update lookfor set title=?, content=? where key_num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, num);

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
	
}
