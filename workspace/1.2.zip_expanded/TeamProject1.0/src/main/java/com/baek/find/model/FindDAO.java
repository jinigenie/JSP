package com.baek.find.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;



public class FindDAO {

	//싱글톤 형태의 클래스로 생성하는 편이 좋다.(싱글톤 - 여러개 호출되어도 한개의 객체만 반환)
	//1. 나 자신의 객체를 스태틱으로 선언
	private static FindDAO instance = new FindDAO();
	//2. 직접 생성하지 못하도록 생성자 제한
	private FindDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//3. getter를 통해서 객체를 반환
	public static FindDAO getInstance() {
		return instance;
	}
	//데이터베이스 연결주소
	//오라클 커넥터
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String uid="JSPMINI";
	private String upw="JSP";


	public void writer(String type,String date,String area, String phone,String title,String content,String id) {

		String sql = "insert into find values(FIND_SEQ.NEXTVAL, ?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn=DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			pstmt.setString(2, date);
			pstmt.setString(3, area);
			pstmt.setString(4, phone);
			pstmt.setString(5, title);
			pstmt.setString(6, content);
			pstmt.setString(7, id);
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
	public List<FindVO>  getList() {
		List<FindVO>list= new ArrayList<>();

		String sql = "select * from find ORDER by KEY_NUM desc";
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
				String time=rs.getString("find_time");
				String area=rs.getString("find_area");
				String ph=rs.getString("ph");
				String title=rs.getString("title");
				String content=rs.getString("content");
				String id=rs.getString("id");

				list.add(new FindVO(num,type, time,area,ph,title,content,id));
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
	public FindVO getContent(String num) {
		FindVO vo=null;
		String sql = "select * from find where key_num =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn=DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs =pstmt.executeQuery();
			if(rs.next()) {


				int num1=rs.getInt("key_num");
				String type=rs.getString("ani_type");
				String time=rs.getString("find_time");
				String area=rs.getString("find_area");
				String ph=rs.getString("ph");
				String title=rs.getString("title");
				String content=rs.getString("content");
				String id=rs.getString("id");

				vo = new FindVO(num1,type,time,area,ph,title,content,id);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}

		}
		return vo;
	}
}

