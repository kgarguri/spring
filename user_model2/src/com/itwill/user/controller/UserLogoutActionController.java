package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;

public class UserLogoutActionController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String forwardpath = "";
		
		//session.invalidate();
		
		
		//response.sendRedirect("user_main.jsp");
		forwardpath = "redirect:user_main.do";

		return forwardpath;
	}
}
