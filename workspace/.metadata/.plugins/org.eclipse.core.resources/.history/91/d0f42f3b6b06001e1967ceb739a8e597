package com.genie.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.genie.user.model.UserDAO;
import com.genie.user.model.UserVO;

public class UserServiceImpl implements UserService {

	@Override
	public int join(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		//아이디 중복 검사
		//싱글톤 객체를 얻는 방법
		UserDAO dao = UserDAO.getInstance();
		int result = dao.idCheck(id);
		
		if(result == 1) { // 아이디 중복
			
			return 1;
			
		} else { // 가입 가능 -> 가입 처리
			
			UserVO vo = new UserVO(id, pw, name, email, gender, null);
			dao.join(vo);
			
			return 0;
		}
		
	}

	@Override
	public UserVO login(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		//로그인
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.login(id, pw);
		
		
		return vo;
	}

	@Override
	public UserVO getInfo(HttpServletRequest request, HttpServletResponse response) {

		//회원아이디 - 이전 화면에서 필요한 값을 넘겨주거나 세션에 저장된 정보를 사용
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		
		//dao호출
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.getInfo(id);
		
		
		return vo;
	}

	
	@Override
	public int updateInfo(HttpServletRequest request, HttpServletResponse response) {
		
		/*
		 * 서비스와 DAO 영역 작성
		 * 1. 아이디 기반으로 회원 정보를 수정
		 * 2. 성공 실패 여부를 컨트롤러로 반환 받기
		 * 3. 수정 성공 시에는 MYPAGE로 리다이렉트
		 * 4. 수정 실패 시에는 MODIFY로 리다이렉트
		 */
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = new UserVO(id, pw, name, email, gender, null);
		
		int res = dao.updateInfo(vo);
		
		
		return res;
	}

	
	
}
