package com.genie.board.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;

import com.genie.board.model.BoardVO;

public interface BoardService {

	//등록
	void regist(HttpServletRequest request, HttpServletResponse response);
	List<BoardVO> getList(HttpServletRequest request, HttpServletResponse response);
	BoardVO getContent(HttpServletRequest request, HttpServletResponse response);
	void update(HttpServletRequest request, HttpServletResponse response);
	
}
