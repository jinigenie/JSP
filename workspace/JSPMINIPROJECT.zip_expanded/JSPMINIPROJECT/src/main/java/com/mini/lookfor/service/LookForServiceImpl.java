package com.mini.lookfor.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mini.lookfor.model.LookForDAO;
import com.mini.lookfor.model.LookForVO;

public class LookForServiceImpl implements LookForService {

	@Override
	public void write(HttpServletRequest request, HttpServletResponse response) {

		String title = request.getParameter("title");
		String id = request.getParameter("id");
		String type = request.getParameter("anymal");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String area = request.getParameter("area");
		String content = request.getParameter("content");
		
		date = date+" "+time;
		
		System.out.println(date);
		LookForDAO dao = LookForDAO.getInstance();
		dao.writeLf(type, date, area, title, content, id);
	
	}

	@Override
	public List<LookForVO> getList(HttpServletRequest request, HttpServletResponse response) {

		LookForDAO dao = LookForDAO.getInstance();
		List<LookForVO> list = dao.getList();
		
		return list;
	}

	@Override
	public LookForVO getContent(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		
		LookForDAO dao = LookForDAO.getInstance();
		LookForVO vo = dao.getContent(num);
		
		return vo;
		
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {

		String bno = request.getParameter("num");
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		LookForDAO dao = LookForDAO.getInstance();
		dao.update(bno, title, content);
		
	}

}
