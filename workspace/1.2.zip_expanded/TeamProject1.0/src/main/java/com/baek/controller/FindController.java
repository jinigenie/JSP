package com.baek.controller;

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
import com.baek.findcomment.model.FindReplyVO;
import com.baek.findreply.service.FindReplyService;
import com.baek.findreply.service.FindReplyServicelmpl;
import com.baek.user.model.UserVO;
import com.baek.user.service.UserService;
import com.baek.user.service.UserServicelmpl;

@WebServlet("*.find")
public class FindController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindController() {
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
		//uri의 주소만 자르고 각 요청 비교
		String command=uri.substring(conPath.length());
		UserService ser=new UserServicelmpl();
		FindService service = new FindServicelmpl(); 


		if(command.equals("/find/writerForm.find")) {
			service.writer(request, response);


			response.sendRedirect("find_list.find");
			//			request.getRequestDispatcher("board_list.jsp").forward(request, response);

		}else if(command.equals("/find/find_list.find")) {

			List<FindVO>list=service.getList(request, response);
			request.setAttribute("list", list);
			request.getRequestDispatcher("find_list.jsp").forward(request, response);
			//			request.getRequestDispatcher("board_list.jsp").forward(request, response);

		}else if(command.equals("/find/find_writer.find")) {
			UserVO vo=ser.getInfo(request, response);


			request.setAttribute("vo", vo);
			request.getRequestDispatcher("find_writer.jsp").forward(request, response);

			//게시글 수정 화면	
		}else if(command.equals("/find/find_content.find")) {


			//화면 나타낼때 댓글 테이블도 리스트로 생성해서 같이 출력 (이떄 리스트 불러오는 기준은 게시글 번호로)
			FindReplyService sv = new FindReplyServicelmpl(); 
			List<FindReplyVO> listcomment= sv.listComment(request, response);
			FindVO vo = service.getContent(request, response);
			request.setAttribute("listcomment", listcomment);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("find_content.jsp").forward(request, response);



		}
	}

}
