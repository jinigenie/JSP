package com.baek.find.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baek.find.model.FindVO;

public interface FindService {

	void writer (HttpServletRequest request, HttpServletResponse response);
	List<FindVO> getList(HttpServletRequest request, HttpServletResponse response);
	FindVO getContent(HttpServletRequest request, HttpServletResponse response);
	
}
