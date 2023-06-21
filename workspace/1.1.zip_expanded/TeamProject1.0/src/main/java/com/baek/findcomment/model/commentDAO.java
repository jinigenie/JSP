package com.baek.findcomment.model;

import com.baek.find.model.FindDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class commentDAO {
	//싱글톤 형태의 클래스로 생성하는 편이 좋다.(싱글톤 - 여러개 호출되어도 한개의 객체만 반환)
		//1. 나 자신의 객체를 스태틱으로 선언
		private static commentDAO instance = new commentDAO();
		//2. 직접 생성하지 못하도록 생성자 제한
		private commentDAO() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		//3. getter를 통해서 객체를 반환
		public static commentDAO getInstance() {
			return instance;
		}
		//데이터베이스 연결주소
		//오라클 커넥터
		private String url="jdbc:oracle:thin:@localhost:1521:xe";
		private String uid="JSPMINI";
		private String upw="JSP";

		public ArrayList<commentVO> listComment(String seq) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				
				// 부모글 번호를 조건으로 받기
				String sql = "select c.*, (select name from users where id = c.id) as name "
						+ "from findComment c where pseq = ? order by seq asc";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, seq);
				
				rs = pstmt.executeQuery();
				
				ArrayList<commentVO> clist = new ArrayList<commentVO>();
				
				while ( rs.next() ) {
					
					commentVO dto = new commentVO();
					
					dto.setSeq(rs.getString("seq"));
					dto.setContent(rs.getString("content"));
					dto.setId(rs.getString("id"));
					dto.setRegdate(rs.getString("regdate"));
					dto.setPseq(rs.getString("pseq"));
					dto.setName(rs.getString("name"));
					
					clist.add(dto);
					
				}
				
				return clist;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		public int addComment(commentVO dto) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				
				String sql = "insert into tblComment (seq, id, content, regdate, pseq)"
						+ " values (seqBoards.nextVal, ?, ?, default, ?)";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getContent());
				pstmt.setString(3, dto.getPseq());
				
				return pstmt.executeUpdate(); // 성공시 1 실패시 0
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return 0;
		}
}
