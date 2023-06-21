package com.baek.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baek.find.service.FindService;
import com.baek.find.service.FindServicelmpl;
import com.baek.findcomment.model.commentDAO;
import com.baek.findcomment.model.commentVO;
import com.baek.findcomment.service.commentService;
import com.baek.findcomment.service.commentServicelmpl;

@WebServlet("*.com")
public class commentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public commentController() {
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
		commentService service = new commentServicelmpl(); 
		if(command.equals("/find/comment.com")) {
			
			String seq = request.getParameter("seq");
			
			// 2.5 - 댓글 목록 가져오기
			List<commentVO> clist = service.listComment(request, response);
			
			// 3.
			request.setAttribute("clist", clist);

			RequestDispatcher dispatcher = request.getRequestDispatcher("find_content.jsp");
			dispatcher.forward(request, response);

			
		}
	}

}
