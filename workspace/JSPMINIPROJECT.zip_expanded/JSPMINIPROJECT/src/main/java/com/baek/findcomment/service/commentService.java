package com.baek.findcomment.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baek.findcomment.model.commentVO;

public interface commentService {
	List<commentVO> listComment(HttpServletRequest request, HttpServletResponse response);
}
