package com.baek.find.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baek.find.model.FindDAO;
import com.baek.find.model.FindVO;

public class FindServicelmpl implements FindService{

	@Override
	public void writer(HttpServletRequest request, HttpServletResponse response) {

		String title = request.getParameter("title");
		String id = request.getParameter("id");
		String type = request.getParameter("anymal");
		String phone = request.getParameter("phone");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String area = request.getParameter("area");
		String content = request.getParameter("content");
		date = date+" "+time;
		System.out.println(date);
		FindDAO dao = FindDAO.getInstance();
		dao.writer(type, date, area,phone,title,content,id);


	}

	@Override
	public List<FindVO> getList(HttpServletRequest request, HttpServletResponse response) {
		FindDAO dao=FindDAO.getInstance();

		List<FindVO> list=dao.getList();



		return list;
	}
	public FindVO getContent(HttpServletRequest request, HttpServletResponse response) {

		String num = request.getParameter("num");
		FindDAO dao = FindDAO.getInstance();
		FindVO vo = dao.getContent(num);

		return vo;
	}

	@Override
	public List<FindVO> getidList(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("user_id");
		FindDAO dao = FindDAO.getInstance();
		List<FindVO> vo = dao.getidList(id);
		
		
		return vo;
	}

	@Override
	public List<FindVO> getTitle(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("searchWord");
		FindDAO dao = FindDAO.getInstance();
		List<FindVO> vo = dao.getTitle(id);
		
		
		return vo;
	}

	@Override
	public List<FindVO> getArea(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("searchWord");
		FindDAO dao = FindDAO.getInstance();
		List<FindVO> vo = dao.getArea(id);
		
		
		return vo;
	}
}
