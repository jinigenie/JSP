package com.mini.lookfor.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baek.find.model.FindVO;
import com.mini.lookfor.model.LookForVO;

public interface LookForService {

	void write(HttpServletRequest request, HttpServletResponse response);
	List<LookForVO> getList(HttpServletRequest request, HttpServletResponse response);
	LookForVO getContent(HttpServletRequest request, HttpServletResponse response);
	void update(HttpServletRequest request, HttpServletResponse response);
}
