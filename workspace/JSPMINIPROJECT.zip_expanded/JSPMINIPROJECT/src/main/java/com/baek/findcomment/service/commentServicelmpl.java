package com.baek.findcomment.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baek.findcomment.model.commentDAO;
import com.baek.findcomment.model.commentVO;

public class commentServicelmpl implements commentService{

	@Override
	public List<commentVO> listComment(HttpServletRequest request, HttpServletResponse response) {

		commentDAO dao=commentDAO.getInstance();

		List<commentVO> list=dao.listComment(request.getParameter("num"));


		return list;
	}

}
