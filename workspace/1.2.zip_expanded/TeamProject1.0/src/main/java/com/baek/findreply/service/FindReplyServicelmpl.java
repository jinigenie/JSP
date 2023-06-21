package com.baek.findreply.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baek.findcomment.model.FindReplyDAO;
import com.baek.findcomment.model.FindReplyVO;

public class FindReplyServicelmpl implements FindReplyService{

	@Override
	public List<FindReplyVO> listComment(HttpServletRequest request, HttpServletResponse response) {

		FindReplyDAO dao=FindReplyDAO.getInstance();

		List<FindReplyVO> list=dao.listComment(request.getParameter("num"));


		return list;
	}

	
	@Override
	public void addComment(HttpServletRequest request, HttpServletResponse response) {
		
		String body=request.getParameter("body");//내용
		//게시물 번호
		//id
		String articleIdx=request.getParameter("content_num");//내용
		String nickname=request.getParameter("id");//내용
		FindReplyVO vo=new FindReplyVO(null, articleIdx, body, nickname, null);
		FindReplyDAO dao =FindReplyDAO.getInstance();
		
		dao.addComment(vo);
	}

}
