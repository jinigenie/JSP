package com.genie.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.genie.user.model.UserVO;

public interface UserService {

	//추상메소드
	int join(HttpServletRequest request, HttpServletResponse response);
	UserVO login(HttpServletRequest request, HttpServletResponse response);
	UserVO getInfo(HttpServletRequest request, HttpServletResponse response);
	
	int updateInfo(HttpServletRequest request, HttpServletResponse response);
	
}
