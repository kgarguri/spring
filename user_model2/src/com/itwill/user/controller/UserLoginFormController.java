package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;

public class UserLoginFormController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String forwardpath = "";
		
		String msg1=(String)request.getAttribute("msg1");
		if(msg1==null)msg1="";
		String msg2=(String)request.getAttribute("msg2");
		if(msg2==null)msg2="";
		User fuser = (User)request.getAttribute("fuser");
		if(fuser==null)fuser=new User("","","","");
		
		forwardpath = "forward:/WEB-INF/views/user_login_form.jsp";
		
		return forwardpath;
	}
}
