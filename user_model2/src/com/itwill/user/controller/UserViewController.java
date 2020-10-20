package com.itwill.user.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserViewController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardpath = "";
		
		String userId = request.getParameter("userId");
		if(userId==null|| userId.equals("")){
			forwardpath = "redidirect:user_main.do";
		}
		User user=null;
		try{
			UserService userService=new UserService();
			user = userService.findUser(userId);
			request.setAttribute("user", user);
			forwardpath = "forward:/WEB-INF/views/user_view.jsp";
		}catch(Exception e){
			e.printStackTrace();
			forwardpath = "redirect:user_error.jsp";
		}
		
		return forwardpath;
	}
}
