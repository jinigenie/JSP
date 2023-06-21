package com.mini.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baek.find.model.FindVO;
import com.baek.find.service.FindService;
import com.baek.find.service.FindServicelmpl;
import com.mini.lookfor.model.LookForVO;
import com.mini.lookfor.service.LookForService;
import com.mini.lookfor.service.LookForServiceImpl;

@WebServlet("*.lookfor")
public class LookForController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LookForController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	//2. get/post하나로 모은다
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//3. 요청분기
		//한글처리
		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		LookForService service = new LookForServiceImpl(); 

		// 등록 작업
		if(command.equals("/lookfor/writeForm.lookfor")) {
			service.write(request, response);
			response.sendRedirect("lookfor_list.lookfor");

		// 목록 화면 처리
		} else if(command.equals("/lookfor/lookfor_list.lookfor")) {

			List<LookForVO>list=service.getList(request, response);
			request.setAttribute("list", list);
			request.getRequestDispatcher("lookfor_list.jsp").forward(request, response);

		// 게시글 상세 화면
		} else if(command.equals("/lookfor/lookfor_content.lookfor")) {

			LookForVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("lookfor_content.jsp").forward(request, response);

		//글쓰기 화면에 처리
		} else if(command.equals("/lookfor/lookfor_write.lookfor")) {

			request.getRequestDispatcher("lookfor_write.jsp").forward(request, response);

		//게시글 수정 화면	
		} else if(command.equals("/board/board_modify.board")) {

			LookForVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("lookfor_modify.jsp").forward(request, response);

		//글 수정	
		} else if(command.equals("/board/lookfor_update.board")) {


			service.update(request, response);
			response.sendRedirect("lookfor_content.lookfor?num=" + request.getParameter("num"));

		}
	}

}
