package com.genie.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	//싱글톤 형태의 클래스로 생성하는 편이 좋음
	//1. 나 자신의 객체를 static으로 선언
	private static BoardDAO instance = new BoardDAO();

	//2. 직접 생성하지 못하도록 생성자 제한
	private BoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		}
	}

	//3. getter를 통해서 객체 반환
	public static BoardDAO getInstance() {
		return instance;
	}

	// DB 연결 주소 + 오라클 커넥터
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "JSP";
	private String upw = "JSP";
	
	//글 등록
	public void regist(String writer, String title, String content) {
		String sql = "INSERT INTO BOARD(BNO, WRITER, TITLE, CONTENT) VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
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
	
	
	//목록 조회
	public List<BoardVO> getList(){
		
		List<BoardVO> list = new ArrayList<>();
		String sql = "SELECT * FROM BOARD ORDER BY BNO DESC";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);	
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			/* 
			 * 조회된 데이터를 순서대로 vo에 담고 리스트에 추가하는 프로그램 코드
			 */
			while(rs.next()) {
				
				//1행에 대한 처리
				
				int bno = rs.getInt("bno");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int hit = rs.getInt("hit");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				BoardVO vo = new BoardVO(bno, writer, title, content, hit, regdate);
				list.add(vo);
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
		
		return list;
	}
	
	
	//글내용 조회
	public BoardVO getContent(String bno) {
		
		BoardVO vo = null;
		String sql = "select * from board where bno = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int bno2 = rs.getInt("bno");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int hit = rs.getInt("hit");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				vo = new BoardVO(bno2, writer, title, content, hit, regdate);
				
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
	public void update(String bno,
					   String title,
					   String content) {
		
		String sql = "update board set title=?, content=? where bno=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, bno);
			
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