package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;

public class UserWriteFormController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String forwardpath = "";
		
		User fuser=(User)request.getAttribute("fuser");
		if(fuser==null){
			fuser=new User("","","","");
		}
		String msg=(String)request.getAttribute("msg");
		if(msg==null)msg="";
		
		forwardpath = "forward:/WEB-INF/views/user_write_form.jsp";
		
		return forwardpath;
	}

}
