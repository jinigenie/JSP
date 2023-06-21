package com.baek.user.controller;

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
			
		}
	}

}
